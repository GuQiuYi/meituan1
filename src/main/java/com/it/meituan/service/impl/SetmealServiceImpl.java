package com.it.meituan.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.meituan.common.CustomException;
import com.it.meituan.dto.SetmealDto;
import com.it.meituan.entity.Setmeal;
import com.it.meituan.entity.SetmealDish;
import com.it.meituan.mapper.SetmealMapper;
import com.it.meituan.service.SetmealDishService;
import com.it.meituan.service.SetmealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SetmealServiceImpl extends ServiceImpl<SetmealMapper, Setmeal> implements SetmealService {
    @Autowired
    private SetmealDishService setmealDishService;

    //实现新增套餐，同时需要保存套餐和菜品的关联关系
    @Transactional
    @Override
    public void saveWithDish(SetmealDto setmealDto) {
        //保存套餐的基本信息，操作setmeal，执行insert操作
        this.save(setmealDto);
        List<SetmealDish> setmealDishes = setmealDto.getSetmealDishes();
        setmealDishes.stream().map((item)->{
            item.setSetmealId(setmealDto.getId());
            return item;
        }).collect(Collectors.toList());

        //保存套餐和菜品的关联信息，操作setmeal_dish，执行insert操作

        setmealDishService.saveBatch(setmealDishes);
    }


    //删除套餐，同时需要删除套餐和菜品的关联
    @Transactional
    @Override
    public void removeWithDish(List<Long> ids) {
        //查询套餐状态，确定是否可以删除
        LambdaQueryWrapper<Setmeal> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.in(Setmeal::getId,ids);
        queryWrapper.eq(Setmeal::getStatus,1);
        //这里的count时满足停售状态的id的数量
        int count=this.count(queryWrapper);
        //如果不能删除，抛出一个业务异常
        if(count>0) {
            throw new CustomException("套餐正在售卖中，不能删除");
        }

        //如果可以删除，先删除套餐表中的数据->setMeal
        this.removeByIds(ids);

        //删除关系表中的数据->setMealDish
        LambdaQueryWrapper<SetmealDish> lambdaQueryWrapper =new LambdaQueryWrapper<>();
        lambdaQueryWrapper.in(SetmealDish::getSetmealId,ids);
        setmealDishService.remove(lambdaQueryWrapper);
    }
}

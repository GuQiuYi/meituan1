package com.it.meituan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.meituan.dto.SetmealDto;
import com.it.meituan.entity.Setmeal;

import java.util.List;

public interface SetmealService extends IService<Setmeal> {
    //新增套餐，同时需要保存套餐和菜品的关联关系
    public void saveWithDish(SetmealDto setmealDto);

    //删除套餐，同时需要删除套餐和菜品的关联
    public void removeWithDish(List<Long> ids);
}

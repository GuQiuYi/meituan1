package com.it.meituan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.meituan.dto.DishDto;
import com.it.meituan.entity.Dish;

public interface DishService extends IService<Dish> {
    //新增菜品，同时插入菜品对应的口味数据，需要操作两张表：dish，dishflavor
    public void saveWithFlavor(DishDto dishDto);
    //根据id查询菜品信息和对应的口味信息
    public DishDto getByIdWithFlavor(Long id);
    //更新菜品信息和对应的口味信息
    public void updateWithFlavor(DishDto dishDto);
}

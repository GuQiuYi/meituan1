package com.it.meituan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.meituan.entity.ShoppingCart;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ShoppingCartMapper extends BaseMapper<ShoppingCart> {

}

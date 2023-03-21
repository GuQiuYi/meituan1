package com.it.meituan.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.meituan.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{
}

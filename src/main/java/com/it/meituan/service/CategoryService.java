package com.it.meituan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.meituan.entity.Category;
import org.springframework.stereotype.Service;


public interface CategoryService extends IService<Category> {
    public void remove(Long id);
}

package com.it.meituan.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.meituan.entity.Orders;

public interface OrderService extends IService<Orders> {

    /**
     * 用户下单
     * @param orders
     */
    public void submit(Orders orders);
}

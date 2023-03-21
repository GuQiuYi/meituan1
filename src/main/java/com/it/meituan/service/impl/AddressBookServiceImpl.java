package com.it.meituan.service.impl;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.meituan.entity.AddressBook;
import com.it.meituan.mapper.AddressBookMapper;
import com.it.meituan.service.AddressBookService;
import org.springframework.stereotype.Service;

@Service
public class AddressBookServiceImpl extends ServiceImpl<AddressBookMapper, AddressBook> implements AddressBookService {
}

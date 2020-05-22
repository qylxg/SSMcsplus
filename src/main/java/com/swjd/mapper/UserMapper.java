package com.swjd.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.swjd.bean.User;

//接口必须继承MyBatisplus的父接口（BaseMapper）因为这个父接口有很多好用的方法
//要指明类型
public interface UserMapper extends BaseMapper<User> {
}

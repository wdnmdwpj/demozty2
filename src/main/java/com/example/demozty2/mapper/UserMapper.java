//mapper层 用途： 对数据库进行数据持久化操作，他的方法语句是直接针对数据库操作的，主要实现一些增删改查操作，在mybatis中方法主要
//        与与xxx.xml内相互一一映射。
package com.example.demozty2.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demozty2.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<User> {

}

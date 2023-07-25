package com.example.demozty2.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demozty2.entity.User;
import com.example.demozty2.mapper.UserMapper;
import com.example.demozty2.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl  implements UserService {/*一个类通过关键字implements声明自己使用一个或者多个接口。*/
    @Resource/*@Service注解用于类上，标记当前类是一个service类，加上该注解会将当前类自动注入到spring容器中，不需要再在applicationContext.
    \xml文件定义bean了。在调用该service的时候只需要将该类注入接口中即可*/
    private UserMapper userMapper;

    @Override
    /*@Override是伪代码,表示重写(当然不写也可以)，不过写上有如下好处:
      1、可以当注释用,方便阅读；
      2、编译器可以给你验证@Override下面的方法名是否是你父类中所有的，如果没有则报错。例如，你如果没写@Override，而你下面的方法名又写错
      了，这时你的编译器是可以编译通过的，因为编译器以为这个方法是你的子类中自己增加的方法。*/
    public int loginCheck(String name, String password) {
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();/*新建一个QueryWrapper对象，类型为User对象，也就是你需要查询的实体数据*/
        queryWrapper.lambda().eq(User::getUserName, name);
        List<User> userList = userMapper.selectList(queryWrapper);
        if (userList.size() == 0) {
            return 0;
        }
        if (!(userList.get(0).getPassword().equals(password))) {
            return 1;
        }
        return 2;
    }
}

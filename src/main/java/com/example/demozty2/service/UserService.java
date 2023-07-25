//service层 用途：业务service层，给controller层的类提供接口进行调用。一般就是自己写的方法封装起来，就是声明一下，具体实现在
//        serviceImpl中。
package com.example.demozty2.service;



import com.example.demozty2.entity.User;

import java.util.List;

public interface UserService {

    int loginCheck(String name,String password);



//    public int addUser(User user);



}

//controller层 用途： 控制层，负责具体模块的业务流程控制，需要调用service逻辑设计层的接口来控制业务流程。因为service中的方法是我们
// 使用到的，controller通过接收前端H5或者App传过来的参数进行业务操作，再将处理结果返回到前端。
package com.example.demozty2.controller;

//import com.example.demozty2.entity.User;
import com.example.demozty2.service.UserService;
import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class UserController {

    @Resource
    private UserService userService;


    @ResponseBody/*@Responsebody 注解表示该方法的返回的结果直接写入 HTTP 响应正文（ResponseBody）中，一般在异步获取数据时使用，通常是在使用
    @RequestMapping 后，返回值通常解析为跳转路径，加上 @Responsebody 后返回结果不会被解析为跳转路径，而是直接写入HTTP 响应正文中。
    作用：
    该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。
    使用时机：
    返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；*/

    @RequestMapping("/userLogin")/*@RequestMapping 是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方
    法都是以该地址作为父路径；用于方法上，表示在类的父路径下追加方法上注解中的地址将会访问到该方法，此处需注意@RequestMapping用在类上可以没用，但
            是用在方法上必须有*/

    public int userLogin(String userName,String password){
        return userService.loginCheck(userName,password);
    }

}

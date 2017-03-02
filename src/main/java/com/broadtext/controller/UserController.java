package com.broadtext.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.broadtext.model.UserModel;
import com.broadtext.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    
    @RequestMapping("userList")
    public Object userList(){
        List<UserModel> list = this.userService.userList();
        return list;
    }
    @RequestMapping("addUser")
    public void insertUser(UserModel userModel){
        if(userModel == null){
            userModel = new UserModel();
        }
        userModel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userModel.setName("兵哥无敌");
        userModel.setAge(18);
        this.userService.insertUser(userModel);
    }
    @RequestMapping("deleteUser")
    public void deleteUserById(String id){
        this.userService.deleteUserById(id);
    }
    @RequestMapping("testTransaction")
    public void testTransaction(UserModel userModel){
        if(userModel == null){
            userModel = new UserModel();
        }
        userModel.setId(UUID.randomUUID().toString().replaceAll("-", ""));
        userModel.setName("兵哥无敌1");
        userModel.setAge(3);
        userModel.setPhone(null);
        this.userService.insAndDel(userModel);
    }
    
}

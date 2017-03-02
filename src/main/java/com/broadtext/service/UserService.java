package com.broadtext.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.broadtext.dao.UserDao;
import com.broadtext.model.UserModel;

@Service("userService")
public class UserService {
    @Autowired
    private UserDao userDao;
    public List<UserModel> userList(){
        return this.userDao.userList();
    }
    /**
     * 
     * <p>Description: 事务的测试用例</p>
     * @param userModel
     */
    public void insAndDel(UserModel userModel){
        this.userDao.insertUser(userModel);
        if(userModel.getPhone().equals("111")){
            
        }
        
        this.userDao.deleteUserById("9ddfb2cb393f4178befc7de12d802f7d");
    }
    
    
    public void insertUser(UserModel userModel){
        this.userDao.insertUser(userModel);
    }
    public void deleteUserById(String id){
        this.userDao.deleteUserById(id);
    }
}

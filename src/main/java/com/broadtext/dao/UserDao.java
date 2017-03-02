package com.broadtext.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.broadtext.model.UserModel;
@Component("userDao")
public class UserDao {
    @Autowired
    private SqlSessionTemplate sqlSession; 
    public List<UserModel> userList(){
        return this.sqlSession.selectList("findUserList");
    }
    
    public void insertUser(UserModel userModel){
        this.sqlSession.insert("insertUser", userModel);
    }
    public void deleteUserById(String id){
        this.sqlSession.delete("deleteUserById", id);
    }
}

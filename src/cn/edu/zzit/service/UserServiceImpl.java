package cn.edu.zzit.service;

import cn.edu.zzit.dao.UserDao;
import cn.edu.zzit.entity.User;

import java.util.List;

public class UserServiceImpl implements UserService{
    UserDao userDao=new UserDao();
    @Override
    public List<User> GetUsersList() {
       return userDao.GetUserList();
    }

    @Override
    public User GetUser(String name, String pwd) {
        return userDao.GetUser(name,pwd);
    }

    @Override
    public void InsertUser(User user) {

    }

    @Override
    public void DeleteUser(int id) {

    }
}

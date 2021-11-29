package cn.edu.zzit.service;
import cn.edu.zzit.entity.*;
import java.util.*;
public interface UserService {
    //查询所有用户
    List<User> GetUsersList();
    //按用户名密码查某个用户
    User GetUser(String name,String pwd);
    //添加一个用户
    void InsertUser(User user);
    //删除一个用户
    void DeleteUser(int id);
}

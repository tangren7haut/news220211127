package cn.edu.zzit.dao;

import cn.edu.zzit.entity.User;
import cn.edu.zzit.util.JDBCUtily;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;

public class UserDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtily.getDataSource());

    /**
     * 查询用户列表
     * @return
     */
    public List<User> GetUserList(){
        String sql="select * from usertable";
        List<User> userlist=new ArrayList<>();
        userlist=jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class));
        return userlist;
    }
    /**
     * 查询某个用户
     * @return
     */
    public User GetUser(String name,String pwd){
        String sql="select * from usertable where uname=? and upwd=?";
        User user=jdbcTemplate.queryForObject(sql,new BeanPropertyRowMapper<>(User.class),name,pwd);
        System.out.println(user);
        return user;
    }

}

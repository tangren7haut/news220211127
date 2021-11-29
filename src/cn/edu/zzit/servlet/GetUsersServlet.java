package cn.edu.zzit.servlet;

import cn.edu.zzit.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getusers")
public class GetUsersServlet extends HttpServlet {
    Connection conn=null;
    PreparedStatement preparedStatement=null;
    ResultSet rs=null;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //查询数据库（news--》usertable）
        //1.连接数据库
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/news";
        String mysqluser="root";
        String pwd="123";
        try {
            Class.forName(driver);//加载驱动
            conn = DriverManager.getConnection(url, mysqluser, pwd);
            String sql = "select * from usertable";
            preparedStatement = conn.prepareStatement(sql);
            rs = preparedStatement.executeQuery();//ResultSet
            List<User> list=new ArrayList<>();
            while (rs.next()) {
                //读出来的数据，id，name,pwd,email--->user实例
                //在把user实例--》list
                User user=new User();
                user.setId(rs.getInt("id"));
                user.setUname(rs.getString("uname"));
                user.setUpwd(rs.getString("upwd"));
                user.setEmail(rs.getString("email"));
                list.add(user);
            }
            request.setAttribute("userList",list);
            request.getRequestDispatcher("admin/userlist.jsp").forward(request,response);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        try {
            rs.close();
            preparedStatement.close();
            conn.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

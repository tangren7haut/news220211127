package cn.edu.zzit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

@WebServlet("/regservlet")
public class RegServlet extends HttpServlet {
    Connection conn=null;
    Statement statement=null;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取注册信息
        String userName=request.getParameter("uname");
        String userPwd=request.getParameter("upwd");
        String userEmail=request.getParameter("uemail");
        String url="jdbc:mysql://127.0.0.1:3306/news";
        PrintWriter pw=response.getWriter();
        //2.把信息写入数据库 添加驱动
        //装载驱动
        try {
            Class.forName("com.mysql.jdbc.Driver");
            //创建连接
            conn = DriverManager.getConnection(url, "root", "123");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        int count=0;
        String sql="insert into usertable values (null,'"+userName+"','"+userPwd+"','"+userEmail+"')";//sql语句拼接 insert
       try {
           statement = conn.createStatement();
           count = statement.executeUpdate(sql);
           if (count > 0) {
               System.out.println("成功");
               pw.write("success...");
           } else {
               System.out.println("fail...");
               pw.write("fail...");
           }
       }
       catch (Exception e){
           System.out.println("exception....");
           pw.write(e.getMessage());
       }
       //释放资源
        try {
            if(!statement.isClosed()){
                statement.close();
            }
            if(!conn.isClosed()) {
                conn.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}

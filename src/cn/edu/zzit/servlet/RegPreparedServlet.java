package cn.edu.zzit.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/regprepared")
public class RegPreparedServlet extends HttpServlet {
    Connection conn=null;
    PreparedStatement preparedStatement=null;
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        String userName=request.getParameter("uname");
        String userPwd=request.getParameter("upwd");
        String userEmail=request.getParameter("uemail");
        //2.链接数据库，写入数据
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://127.0.0.1:3306/news";
        String user="root";
        String pwd="123";
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, user, pwd);
            String sql = "insert into usertable values (null,?,?,?)";
            preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, userPwd);
            preparedStatement.setString(3, userEmail);
           int count= preparedStatement.executeUpdate();
           if(count>0){
               System.out.println("success...");
           }
           else{
               System.out.println("fail...");
           }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

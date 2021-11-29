package cn.edu.zzit.servlet;

import cn.edu.zzit.entity.User;
import cn.edu.zzit.service.UserService;
import cn.edu.zzit.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    UserService userService=new UserServiceImpl();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name=request.getParameter("uname");
        String pwd=request.getParameter("upwd");
       User user= userService.GetUser(name,pwd);
        System.out.println(user);
    }
}

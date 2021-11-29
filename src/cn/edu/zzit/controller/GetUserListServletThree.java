package cn.edu.zzit.controller;

import cn.edu.zzit.entity.User;
import cn.edu.zzit.service.UserService;
import cn.edu.zzit.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/getuserlistwiththree")
public class GetUserListServletThree extends HttpServlet {
    UserService userService=new UserServiceImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> userList=new ArrayList<>();
       userList= userService.GetUsersList();
       req.setAttribute("userlist",userList);
       req.getRequestDispatcher("admin/userlist2.jsp").forward(req,resp);
    }
}

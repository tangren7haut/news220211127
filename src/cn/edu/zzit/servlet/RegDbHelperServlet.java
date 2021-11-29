package cn.edu.zzit.servlet;

import cn.edu.zzit.util.DbHelper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/regdbhelper")
public class RegDbHelperServlet extends HttpServlet {
    DbHelper dbHelper=new DbHelper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.接收数据
        String userName=request.getParameter("uname");
        String userPwd=request.getParameter("upwd");
        String userEmail=request.getParameter("uemail");
        String sql = "insert into usertable values (null,?,?,?)";
        String[] param={userName, userPwd,userEmail};
       int affectline= dbHelper.executeUpdate(sql,param);//影响的行数
       if(affectline>0){
           System.out.println("success...");
           request.setAttribute("msg","注册成功！");
       }
       else{
           System.out.println("fail...");
           request.setAttribute("msg","注册失败！");
       }
       request.getRequestDispatcher("result.jsp").forward(request,response);
    }
}

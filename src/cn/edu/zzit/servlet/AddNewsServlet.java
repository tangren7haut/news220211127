package cn.edu.zzit.servlet;

import cn.edu.zzit.entity.News;
import cn.edu.zzit.util.DbHelper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addnewsservlet")
public class AddNewsServlet extends HttpServlet {
    DbHelper dbHelper=new DbHelper();
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /**
         * 1.接收数据
         * 2.直接录入数据
         */
//        String title=request.getParameter("title");
        Map<String,String[]> map= request.getParameterMap();
        News news=new News();
        try {
            //把接收的数据封装到了一个news实例中
            BeanUtils.populate(news,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        String sql="insert into newstable values (null,?,?,?,?,0)";
        String[] params={news.getTitle(),news.getContent(),news.getSource(),news.getPubdate()};
        int count=  dbHelper.executeUpdate(sql,params);
        if(count>0){
            System.out.println("success...");
        }
        else{
            System.out.println("fail...");
        }
    }
}

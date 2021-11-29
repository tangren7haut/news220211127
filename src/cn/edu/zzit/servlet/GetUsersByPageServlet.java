package cn.edu.zzit.servlet;

import cn.edu.zzit.entity.User;
import cn.edu.zzit.util.DbHelper;
import cn.edu.zzit.util.JDBCUtily;
import cn.edu.zzit.util.PageBean;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/getusersbypage")
public class GetUsersByPageServlet extends HttpServlet {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtily.getDataSource());
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取数据
        String currentPage = request.getParameter("currentPage");//当前页码
        String rows = request.getParameter("rows");//每页显示多少行
        if (null == currentPage || "".equals(currentPage)) {
            currentPage = "1";
        }
        if (null == rows || "".equals(rows)) {
            rows = "3";
        }
        //封装pagebean
        PageBean<User> pageBean = findUserByPage(Integer.parseInt(currentPage), Integer.parseInt(rows));
        request.setAttribute("pageBean", pageBean);
        request.getRequestDispatcher("admin/userlist.jsp").forward(request, response);

    }

    private PageBean<User> findUserByPage(int currentPage, int rows) {
        PageBean<User> pageBean = new PageBean<>();
        if (currentPage <= 0) { //
            currentPage = 1;
        }
        int totalCount = findTotalCount();//获取总行数
        System.out.println("总行数:" + totalCount);
        //计算总页数
        int totalPage = totalCount % rows == 0 ? totalCount / rows : totalCount / rows + 1;
        pageBean.setTotalPage(totalPage);
        System.out.println("总页数:" + totalPage);
        if (currentPage > totalPage) {
            currentPage = totalPage;
        }
        List<User> list = findUserByPageImpl(currentPage, rows);//查询当前页的数据

        pageBean.setTotalCount(totalCount);
        pageBean.setCurrentPage(currentPage);
        pageBean.setRows(rows);
        pageBean.setList(list);
        return pageBean;
    }

    private List<User> findUserByPageImpl(int currentPage, int rows) {
        String sql = "select * from usertable limit ? , ? ";
//        Integer[] param = {(currentPage - 1)*rows, rows};
//        List<Object> list = dbHelper.excuteQuery(sql, param);
        List<User> list = jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(User.class),(currentPage - 1)*rows, rows);

        return list;
    }

    private int findTotalCount() {
        int count = 0;
        String sql = "select count(*) from usertable";
        count = jdbcTemplate.queryForObject(sql,Integer.class);
        return count;

    }

}

package cn.edu.zzit.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtily {
    private static DataSource ds;
    static {
        try {
            Properties properties = new Properties();
            properties.load(JDBCUtily.class.getClassLoader().getResourceAsStream("druid.properties"));
            ds = DruidDataSourceFactory.createDataSource(properties);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
    /**
     * 获取链接
     */
    public static Connection getConnection() throws SQLException{
        return  ds.getConnection();
    }
    /**
     * 释放资源
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn) throws SQLException {
        if(rs!=null){
            rs.close();
        }
        if(stmt!=null){
            stmt.close();
        }
        if(conn!=null){
            conn.close();
        }

    }
    public static DataSource getDataSource(){
        return ds;
    }
}

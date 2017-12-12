package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
    static String ip = "127.0.0.1";
    static String port = "3306";
    static String database = "hutubill";
    static String encoding = "UTF-8";
    static String loginName = "root";
    static String password = "root";

    static {
        try {
            //加载驱动
            Class.forName("com.mysql.jdbc.Driver");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     * 获取数据库连接
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException{
        String url = String.format("jdbc:mysql://%s:%s/%s?characterEncoding=%s",
                ip, port, database, encoding);
        return DriverManager.getConnection(url, loginName, password);
    }
}

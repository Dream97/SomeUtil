import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static java.lang.System.out;

/**
 * Created by asus on 2017/4/24.
 */
public class TesTJDBC {
    public static void main(String[] args)
    {
        try {
            // 加载数据库驱动，注册到驱动管理器
            Class.forName("com.mysql.jdbc.Driver");
            // 数据库连接字符串
            String url = "jdbc:mysql://localhost:3306/javaee";
            // 数据库用户名
            String username = "Dream97";
            // 数据库密码
            String password = "1248310717";
            // 创建Connection连接
            Connection conn = DriverManager.getConnection(url,username,password);
            // 判断 数据库连接是否为空
            if(conn != null){
                // 输出连接信息
                out.println("数据库连接成功！");
                // 关闭数据库连接
                conn.close();
            }else{
                // 输出连接信息
                out.println("数据库连接失败！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            out.println("ClassNotFound");
        } catch (SQLException e) {
            e.printStackTrace();
            out.println("SQLEXception");
        }
    }
}

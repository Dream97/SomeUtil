import javax.swing.*;
import java.sql.*;

import static java.lang.System.out;

/**
 * Created by asus on 2017/5/12.
 */
public class ConnectSQL {
    private Connection conn;
    private static ConnectSQL instance;
    private ConnectSQL(){
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
            conn = DriverManager.getConnection(url,username,password);
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
    public static ConnectSQL getInstance()
    {
        if(instance==null)
        {
            instance = new ConnectSQL();
        }
        return instance;
    }


    /**
     * 登录
     * @param id
     * @param password
     * @return
     */
    public boolean login(int id,int password)
    {
        String sql="select *from login where name='"+id+"'and password='"+password+"'";
        try(
//                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
//                        + "User=root&password=768696&useUnicode=true&characterEncoding=UTF8");
                Statement statement = conn.createStatement();
                ResultSet rs=statement.executeQuery(sql))

        {   //如果查询的ResultSet里有超过一条的记录，则登录成功
            if (rs.next())
            {
                return true;
            }

        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        return false;
    }
    public boolean register(int id,String name,int password)
    {
        if (login(id, password))
        {
            //JOptionPane.showMessageDialog(jf, "您已经有账号了请直接登录。");
            out.println("已经注册了");
            return false;
        }
        else
        {
            String sql="insert ignore into login values(?,?,?)";
//            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test?"
//                    + "User=root&password=768696&useUnicode=true&characterEncoding=UTF8");
            PreparedStatement pstmt = null;
            try {
                pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1,id);
                pstmt.setString(2, name);
                pstmt.setInt(3,password);
                pstmt.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
       }
        return true;
    }

//    public  Integer getAll() {
//        String sql = "select * from login";
//        PreparedStatement preparedStatement =null;
//        try {
//            preparedStatement = conn.prepareStatement(sql);
//            ResultSet rs = preparedStatement.executeQuery();
//            int col = rs.getMetaData().getColumnCount();
//            System.out.println("============================");
//            while (rs.next()) {
//                for (int i = 1; i <= col; i++) {
//                    System.out.print(rs.getString(i) + "\t");
//                    if ((i == 2) && (rs.getString(i).length() < 8)) {
//                        System.out.print("\t");
//                    }
//                }
//                System.out.println("");
//            }
//            System.out.println("============================");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

}

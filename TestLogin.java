import static java.lang.System.out;

/**
 * Created by asus on 2017/5/12.
 */
public class TestLogin {
    public static void main(String[] args)
    {
//        ConnectSQL connectSQL = ConnectSQL.getInstance();
//        Boolean flag = connectSQL.register(664624,"疯致远",123456);
//        if(flag)
//        {
//            out.println("注册成功");
//        }else {
//            out.println("注册失败");
//        }
//        Boolean flag1 = connectSQL.login(664624,123456);
//        if(flag1)
//        {
//            out.println("登录成功");
//        }else {
//            out.println("登录失败");
//        }
        //int i = connectSQL.getAll();

        JDBCOperation.getAll();
//        JDBCOperation.insert(new User("664624", "疯致远", "123456"));
//        JDBCOperation.getAll();
//        int i = JDBCOperation.select("664624","123456");
//        if(i == 1)
//        {
//            System.out.println("登录成功");
//        }
    }

}

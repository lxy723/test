package login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConn {
    //  public static void main(String[] args)throws Exception {
//      createDBConn();
//
//      System.out.println("成功");
//      Statement state = createDBConn().createStatement();
//      System.out.println(state);
//  }
    public static Connection createDBConn(){
        //得到数据连接
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/test"+"?serverTimezone=GMT%2B8","root","123");
            return conn;
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }
    public static void closeConn(Connection conn){
        try{
            conn.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}

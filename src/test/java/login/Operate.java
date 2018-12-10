package login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Operate {
    private Connection conn = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    public  void login(){
        Scanner scan = new Scanner(System.in);
        int i = 3;
        String username = null;
        String password = null;
        while(i != -1){              //循环进行
            System.out.print("请输入总系统用户名：");
            username = scan.next();         //输入用户名

            while(username == null){    //判断用户名是否为空
                System.out.print("请输入总系统用户名：");
                username = scan.next();
            }

            System.out.println("请输入总系统密码：");
            password = scan.next();        //输入密码

            while(password == null){      //判断密码是否为空
                System.out.println("请输入总系统密码：");
                password = scan.next();
            }
//          String str1 = "su";         //定义初始用户名
//          String str2 = "su";
//              //定义初始密码
            if(checkUserLogin(username,password)){    //比较输入的用户名、密码是否和初始值相同
                System.out.println("欢迎"+username+",您已成功登录");
                new Menu();
            }
            else{
                if(i == 0){      //三次登陆都错，退出系统
                    System.out.println("对不起，您三次都输入错误，系统将退出！！！");
                    System.exit(1);
                }
                System.out.println("对不起您输入的用户名或密码有误，请重新输入（"+ i-- +"次机会）！！！");
            }



        }
        scan.close();


    }

    public  void register(){
        User user = new User();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您的姓名：");
        String username = input.next();
        user.setUsername(username);
        System.out.println("请输入您的密码：");
        String userpassword = input.next();
        user.setUserpassword(userpassword);

        try {
            if(doAdd(user)){
                System.out.println("注册成功！");
            }else{
                System.out.println("注册失败！");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public  boolean checkUserLogin(String userName,String userPwd){
        boolean flag = false;
        User user = null;
        try{
            conn = DBConn.createDBConn();
            String sql = "select * from user where username=? and userpassword=?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, userName);
            ps.setString(2, userPwd);
            rs = ps.executeQuery();
            while(rs.next()){
                user = new User();
                user.setUsername(rs.getString("username"));
                user.setUserpassword(rs.getString("userpassword"));
            }
            flag = true;
        }catch(Exception ex){
            ex.printStackTrace();
        }finally{
            DBConn.closeConn(conn);
        }
        return flag;
    }

    public boolean doAdd(User user) throws Exception{
        boolean flag = false;
        PreparedStatement pstmt = null;
        String sql = "INSERT INTO user(username,userpassword)" + "VALUES(?,?)";
        try{
            conn = DBConn.createDBConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getUserpassword());

            if (pstmt.executeUpdate() > 0) {
                flag = true;
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (pstmt != null) {
                try {
                    pstmt.close();
                } catch (Exception e1) {

                }
            }
        }
        return flag;
    }
}

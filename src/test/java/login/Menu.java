package login;

import java.util.Scanner;

public class Menu {
    Operate operate = new Operate();
    public Menu(){
        while (true){
            this.show();
        }
    }
    public void show(){
        System.out.println("欢迎进入信息管理系统");
        System.out.println("***1-登录***");
        System.out.println("***2-注册***");
        System.out.println("***0-系统退出***");
        Scanner input = new Scanner(System.in);
        System.out.println("请选择：");
        int i = input.nextInt();
        switch(i){

            case 1 : {
                operate.login();
                break;
            }
            case 2 : {
                operate.register();
                break;
            }

            case 0 : {
                System.exit(1);
                break;
            }
            default: {
                System.out.println("请选择正确的操作！");
            }
        }
    }
}

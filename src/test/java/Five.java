import java.awt.Color;
        import java.awt.Font;
        import java.awt.Graphics;
        import java.awt.event.MouseEvent;
        import java.awt.event.MouseListener;
        import java.awt.image.BufferedImage;
        import java.io.File;
        import java.io.IOException;

        import javax.imageio.ImageIO;
        import javax.swing.*;


class Five extends JFrame implements MouseListener
{
    int score_black=0;//白方比分
    int score_white=0;//黑方比分
    int indexX=0;
    int indexY=0;
    boolean win=false;//如果有哪一方获胜即不能再下了
    BufferedImage img=null;
    String info="黑方下棋";
    String baifang="";
    String heifang="";
    int settime=10;
    int second_white=settime;
    int second_black=settime;
    int mouseX;//绘制棋子的X坐标
    int mouseY;//绘制棋子的Y坐标
    int[][] allchess=new int[19][19];
    boolean isBlack=true;
    Font font=new Font("粗体",Font.BOLD,25);
    Five()
    {
        try {
            img= ImageIO.read(new File("chuanxi.jpg"));
        } catch (IOException e) {
            // TODO 自动生成的 catch 块
            e.printStackTrace();
        }
        setTitle("五子棋");
        setSize(500, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addMouseListener(this);
        setResizable(false);
        setVisible(true);

    }

    public String setTime(int second)
    {
        String min=second/60+"";
        String sec=second%60+"";
        if(sec.length()==1)
        {
            sec="0"+sec;
        }
        return min+":"+sec;

    }


    @Override
    public void paint(Graphics g) {

        g.drawImage(img, 0, 25, null);
        for(int i=0;i<=(360/20);i++)
        {
            g.drawLine(10, 75+20*i, 370, 75+20*i);
            g.drawLine(10+20*i, 75, 10+20*i, 435);
        }
        g.setFont(font);
        g.drawString(info, 230, 60);
        baifang="白方："+setTime(second_white);
        heifang="黑方："+setTime(second_black);
        g.drawString(baifang, 27, 480);
        g.drawString(heifang, 250, 480);
        g.drawString("黑:白"+score_black+":"+score_white, 390, 255);
        /*
         * 如果为1则是白棋子
         * 如果为2则是黑棋子
         * 如果为0则是空位
         */

        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {

                if(allchess[i][j]==1)
                {
                    g.setColor(Color.BLACK);
                    g.fillOval(20*i+10-7, 20*j+75-7, 14, 14);


                }
                else if (allchess[i][j]==2)
                {
                    g.setColor(Color.WHITE);
                    g.fillOval(20*i+10-7, 20*j+75-7, 14, 14);

                }
            }
        }


    }
    //白方线程
    Runnable r_white=new Runnable() {

        @Override
        public void run() {
            while(second_white>0 && !isBlack && !win)
            {
                second_black=settime;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO 自动生成的 catch 块
                    e.printStackTrace();
                }
                second_white--;
                repaint();
            }
            if(second_white==0)
            {
                while(true)
                {
                    int x=(int)(Math.random()*19);
                    int y=(int)(Math.random()*19);
                    if(allchess[x][y]==0)
                    {
                        info="黑方下棋";
                        allchess[x][y]=2;
                        break;
                    }
                }
                isBlack=true;
                new Thread(r_black).start();

            }

        }
    };
    //黑方线程
    Runnable r_black=new Runnable() {

        @Override
        public void run() {
            while(second_black>0 && isBlack && !win)
            {
                second_white=settime;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
                second_black--;
                repaint();
            }
            if(second_black==0)
            {
                while(true)
                {
                    int x=(int)(Math.random()*19);
                    int y=(int)(Math.random()*19);
                    if(allchess[x][y]==0)
                    {
                        info="白方下棋";
                        allchess[x][y]=1;
                        break;
                    }
                }
                isBlack=false;
                new Thread(r_white).start();
            }


        }
    };
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO 自动生成的方法存根
        mouseX=e.getX();
        mouseY=e.getY();
        System.out.println("X"+mouseX);
        System.out.println("Y"+mouseY);
        if(!win)
        {
            if(mouseX>10 && mouseX<370 && mouseY>10 && mouseY<435 )
            {
                indexX=Math.round((mouseX-10)/20.0f);
                indexY=Math.round((mouseY-70)/20.0f);
                if(isBlack)
                {
                    if(allchess[indexX][indexY]==0)
                    {
                        info="白方下棋";
                        allchess[indexX][indexY]=1;
                        if(isWin() || isWinShangxie() || isWinshu() || isWinXiaxie())
                        {   win=true;
                            JOptionPane.showMessageDialog(this, "黑方获胜");
                            score_black++;

                        }
                        isBlack=false;
                        if(!win) //如果没有判断赢，则会运行
                        {
                            new Thread(r_white).start();
                        }
                    }
                }
                else
                {
                    if(allchess[indexX][indexY]==0)
                    {
                        info="黑方下棋";
                        allchess[indexX][indexY]=2;
                        if(isWin() || isWinShangxie() || isWinshu() || isWinXiaxie())
                        {
                            win=true;
                            JOptionPane.showMessageDialog(this, "白方获胜");
                            score_white++;


                        }
                        isBlack=true;
                        if(!win)//如果没有判断赢，则会运行
                        {
                            new Thread(r_black).start();
                        }
                    }

                }
                this.repaint();
            }

        }//while结束
        if(mouseX>400 && mouseX<470 && mouseY>76 && mouseY<106 )//重新开始
        {
            int choose=JOptionPane.showConfirmDialog(this, "确定重新开始么？");
            if(choose==0)
            {
                start();
            }

        }
        if(mouseX>400 && mouseX<470 && mouseY>126 && mouseY<155 )//设置时间
        {
            if(win)
            {
                String  resetTime=JOptionPane.showInputDialog("请输入要重设的时间:");
                settime=Integer.parseInt(resetTime);
                second_black=settime;
                second_white=settime;
                this.repaint();
            }
            else
            {
                JOptionPane.showMessageDialog(this, "当前处于游戏中不允许设置时间");

            }

        }
        if(mouseX>400 && mouseX<470 && mouseY>275 && mouseY<305  )//认输
        {
            if(!win)
            {
                int choose=JOptionPane.showConfirmDialog(this, "确定认输么？");
                if(choose==0)
                {
                    win=true;
                    if(isBlack)
                    {
                        score_white++;
                        int choose1=JOptionPane.showConfirmDialog(this, "黑方认输");
                        if(choose1==0)
                        {
                            int choose2=JOptionPane.showConfirmDialog(this, "重新开局？");
                            if(choose2==0)
                            {
                                start();
                            }
                        }
                    }


                    else
                    {
                        score_black++;
                        int choose1=JOptionPane.showConfirmDialog(this, "白方认输");
                        if(choose1==0)
                        {
                            int choose2=JOptionPane.showConfirmDialog(this, "重新开局？");
                            if(choose2==0)
                            {
                                start();
                            }
                        }
                    }
                }
            }
            else
            {
                JOptionPane.showMessageDialog(this, "游戏还未开始");
            }
        }

    }

    //**************************************重新开始 start*********************//
    public void start()
    {

        win=false;
        isBlack=true;
        info="黑方下棋";
        for(int i=0;i<19;i++)
        {
            for(int j=0;j<19;j++)
            {
                allchess[i][j]=0;
            }
        }
        second_white=settime;
        second_black=settime;
        this.repaint();
    }
    //**************************************重新开始 end*********************//

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO 自动生成的方法存根

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO 自动生成的方法存根

    }
    /*****************************判断旗子*****************************************/
    //判断竖线
    public boolean isWinshu()
    {
        int countY=1;//累计竖线棋子
        int up=1;
        int down=1;
        //判断竖线

        while((indexY+up)<19 && allchess[indexX][indexY]==allchess[indexX][indexY+up])//判断当前点和上边的点是不是同一颜色
        {
            countY++;
            up++;

        }

        while((indexY-down)>=0 && allchess[indexX][indexY]==allchess[indexX][indexY-down])//判断当前点和下边的点是不是同一颜色
        {
            countY++;
            down++;

        }

        if(countY>=5)
        {
            return true;
        }


        return false;

    }
    //上斜线
    public boolean isWinShangxie()
    {
        int countUp=1;//累计上对角棋子
        //
        int sXieshangX=1;
        int sXiexiaX=1;
        int sXieshangY=1;
        int sXiexiaY=1;
        //判断上对角线

        while((indexX+sXiexiaX)<19 && (indexY+sXiexiaY)<19 && allchess[indexX][indexY]==allchess[indexX+sXiexiaX][indexY+sXiexiaY])//判断当前点和右边的点是不是同一颜色
        {


            System.out.println("上对角线");
            System.out.println(indexX+sXiexiaX);
            System.out.println(indexY+sXiexiaY);
            countUp++;
            sXiexiaX++;
            sXiexiaY++;

        }
        while((indexX-sXieshangX)>=0 && (indexY-sXieshangY)>=0 && allchess[indexX][indexY]==allchess[indexX-sXieshangX][indexY-sXieshangY])//判断当前点和左边的点是不是同一颜色
        {
            System.out.println("上对角线");
            System.out.println(indexX-sXieshangX);
            System.out.println(indexY-sXieshangY);
            countUp++;
            sXieshangX++;
            sXieshangY++;
        }

        if(countUp>=5)
        {
            return true;
        }


        return false;

    }
    //下斜线
    public boolean isWinXiaxie()
    {
        int countDowm=1;//累计下对角棋子
        int xXieshangX=1;
        int xXiexiaX=1;
        int xXieshangY=1;
        int xXiexiaY=1;
        //判断下对角线
        while((indexX-xXieshangX)>=0 && (indexY+xXieshangY)<19 && allchess[indexX][indexY]==allchess[indexX-xXieshangX][indexY+xXieshangY])//判断当前点和右边的点是不是同一颜色
        {
            System.out.println("下对角线");
            System.out.println(indexY-xXieshangX);
            System.out.println(indexX+xXieshangY);

            countDowm++;
            xXieshangX++;
            xXieshangY++;

        }
        while((indexY-xXiexiaX)>=0 && (indexX+xXiexiaY)<19 && allchess[indexX][indexY]==allchess[indexX+xXiexiaY][indexY-xXiexiaX])//判断当前点和左边的点是不是同一颜色
        {
            countDowm++;
            xXiexiaX++;
            xXiexiaY++;

        }

        if(countDowm>=5)
        {
            return true;
        }


        return false;
    }
    //判断横输赢
    public boolean isWin()
    {
        int countX=1;//累计横线棋子
        int right=1;
        int left=1;

        //判断横线
        while((indexX+right)<19 && allchess[indexX][indexY]==allchess[indexX+right][indexY])//判断当前点和右边的点是不是同一颜色
        {

            countX++;
            right++;

        }

        while((indexX-left)>=0 && allchess[indexX][indexY]==allchess[indexX-left][indexY])//判断当前点和左边的点是不是同一颜色
        {
            countX++;
            left++;

        }




        if(countX>=5)
        {
            return true;
        }


        return false;
    }


}


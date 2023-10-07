import ShapeClass.*;
import com.sun.source.tree.NewArrayTree;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Time;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class GameJFrame extends JFrame implements KeyListener{
    int data[][]=new int[20][10];
    int test[][]=new int[20][10];
    int xNum=20;
    int yNum=10;
    int speed=500;

    private Shape0 nowShape;
    Timer timer =new Timer();
    TimerTask task =new TimerTask() {
        @Override
        public void run() {
            System.out.println("运行");
            moveDown();
        }
    };
    JLabel[][] jLabels=new JLabel[xNum][yNum];
    public GameJFrame(){
        //初始化窗口
        initJFrame();
        createShape();
        initData();

        initNetJLabel();
        initTime();
        test = new int[][] {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1, 1, 1, 1, 1}

        };

        this.setVisible(true);
    }

    private void initTime() {

        timer.scheduleAtFixedRate(task,1000,speed);
    }

    private void initJFrame(){
        //设置界面的宽高
        this.setSize(480, 960);
        //设置界面标题
        this.setTitle("游戏界面");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置界面关闭形式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE );
        this.addKeyListener(this);
        //取消默认居中放置
        //this.setLayout(null);


    }
    private void initData(){

        int x=nowShape.getLoc()[0];
        int y=nowShape.getLoc()[1];
        for(int i=0;i<test.length;i++){
            for(int j=0;j<test[i].length;j++){
                if(test[i][j]<0){
                    test[i][j]=0;
                }
            }
        }
        for(int i=0;i<nowShape.getPlace().length;i++){
            for (int j=0;j<nowShape.getPlace()[i].length;j++){
                //System.out.print("("+nowShape.getPlace()[i][j]+")");
                if(nowShape.getPlace()[i][j]==1){
                    test[x+i][y+j]+=nowShape.getPlace()[i][j];
                }

            }

        }
        //测试输出
        for(int i=0;i<test.length;i++){
            for (int j=0;j<test[i].length;j++){
                System.out.print("("+test[i][j]+")");
            }
            System.out.println();
        }
        System.out.println();

    }
    private void initNetJLabel(){
        this.getContentPane().removeAll();
        JPanel panel =new JPanel(new GridLayout(xNum,yNum));

        for (int i=0;i<xNum;i++){
            for (int j=0;j<yNum;j++){
                if(test[i][j]==1){
                    JLabel jimg=new JLabel(new ImageIcon("image\\blue.png"));
                    jLabels[i][j]=jimg;
                    jLabels[i][j].setBorder(new BevelBorder(0));

                }
                JLabel jLabel=new JLabel(i+","+j+"@"+test[i][j]);
                if(test[i][j]!=1){
                    jLabels[i][j]=jLabel;
                    if(test[i][j]==1){
                        jLabels[i][j].setBorder(new BevelBorder(0));
                    }
                }

                panel.add(jLabels[i][j]);

            }
        }

        this.getContentPane().add(panel);
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    private void createShape(){
        int rand=new Random().nextInt(1,8);
        switch (rand){
            case 1 -> nowShape=new Shape01();
            case 2 -> nowShape=new Shape02();
            case 3 -> nowShape=new Shape03();
            case 4 -> nowShape=new Shape04();
            case 5 -> nowShape=new Shape05();
            case 6 -> nowShape=new Shape06();
            case 7 -> nowShape=new Shape07();

        }
        System.out.println(rand);
        //nowShape.toString();

    }


    @Override
    public void keyTyped(KeyEvent e) {

    }
    int a=0;
    @Override
    public void keyPressed(KeyEvent e) {
        //timer.scheduleAtFixedRate(,1000,speed);
        if(e.getKeyCode()==40&&a==0){
            speed=300;
            timer.cancel();
            task.cancel();
            timer=new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("运行");
                    moveDown();
                }
            };

            timer.scheduleAtFixedRate(task,1000,speed);
            a=1;
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

        if(e.getKeyCode()==37){
            moveLeft();
        }
        if(e.getKeyCode()==39){
            moveRight();
        }
        if (e.getKeyCode()==38){
            moveSpin();
        }
        if (e.getKeyCode()==40){
            speed=500;
            timer.cancel();
            task.cancel();
            timer=new Timer();
            task = new TimerTask() {
                @Override
                public void run() {
                    System.out.println("运行");
                    moveDown();
                }
            };

            timer.scheduleAtFixedRate(task,1000,speed);
            a=0;
        }


    }

    private void rePaint(){
        int x=nowShape.getLoc()[0];
        int y=nowShape.getLoc()[1];

        for(int i=0;i<nowShape.getPlace().length;i++){
            for (int j=0;j<nowShape.getPlace()[i].length;j++){
                //System.out.print("("+nowShape.getPlace()[i][j]+")");
                if(nowShape.getPlace()[i][j]==1){
                    test[x+i][y+j]-=nowShape.getPlace()[i][j];
                }

            }

        }

    }
    private void moveDown(){
        Crush();
        int[] nowLoc= nowShape.getLoc();

        int x=nowShape.getLoc()[0];
        int y=nowShape.getLoc()[1];

        for(int i=0;i<nowShape.getPlace().length;i++){
            for (int j=0;j<nowShape.getPlace()[i].length;j++){
                //System.out.print("("+nowShape.getPlace()[i][j]+")");
                if(nowShape.getPlace()[i][j]==1){
                    test[x+i][y+j]-=nowShape.getPlace()[i][j];
                }

            }

        }
        nowLoc[0]++;
        nowShape.setLoc(nowLoc);
        initData();
        initNetJLabel();
    }
    private void moveRight(){
        int[] nowLoc= nowShape.getLoc();
        int x=nowShape.getLoc()[0];
        int y=nowShape.getLoc()[1];

        for(int i=0;i<nowShape.getPlace().length;i++){
            for (int j=0;j<nowShape.getPlace()[i].length;j++){
                //System.out.print("("+nowShape.getPlace()[i][j]+")");
                if(nowShape.getPlace()[i][j]==1){
                    test[x+i][y+j]-=nowShape.getPlace()[i][j];
                }

            }

        }
        nowLoc[1]++;
        nowShape.setLoc(nowLoc);
        initData();
        initNetJLabel();
    }
    private void moveLeft(){
        int[] nowLoc= nowShape.getLoc();
        int x=nowShape.getLoc()[0];
        int y=nowShape.getLoc()[1];

        for(int i=0;i<nowShape.getPlace().length;i++){
            for (int j=0;j<nowShape.getPlace()[i].length;j++){
                //System.out.print("("+nowShape.getPlace()[i][j]+")");
                if(nowShape.getPlace()[i][j]==1){
                    test[x+i][y+j]-=nowShape.getPlace()[i][j];
                }

            }

        }
        nowLoc[1]--;
        nowShape.setLoc(nowLoc);
        initData();
        initNetJLabel();
    }
    private void moveSpin(){

        int x=nowShape.getLoc()[0];
        int y=nowShape.getLoc()[1];

        for(int i=0;i<nowShape.getPlace().length;i++){
            for (int j=0;j<nowShape.getPlace()[i].length;j++){
                //System.out.print("("+nowShape.getPlace()[i][j]+")");
                if(nowShape.getPlace()[i][j]==1){
                    test[x+i][y+j]-=nowShape.getPlace()[i][j];
                }

            }

        }
        nowShape.Spin();
        initData();
        initNetJLabel();
    }
    private boolean Crush(){

        for(int j=0;j<nowShape.getBordnum();j++){
            for(int i=nowShape.getBordnum()-1;i>=0;i--){
                if(nowShape.getPlace()[i][j]==1){
                    if (test[nowShape.getLoc()[0]+i+1][nowShape.getLoc()[1]+j]==1){
                        timer.cancel();
                        task.cancel();

                        /*for(int x=0;x<test.length;x++){
                            if(Arrays.stream(test[x]).sum()==10){
                                for(int i1=0;i1<test.length;i1++){
                                    for(int j1=0;j1<test[i].length;j1++){
                                        if(test[i1][j1]==1){
                                            test[i1][j1]=0;
                                            if(i1<=19){
                                                test[i1+1][j1]=1;
                                            }

                                        }
                                    }
                                }
                            }
                        }*/
                        for(int x=0;x<test.length;x++){
                            if(Arrays.stream(test[x]).sum()==10){
                                System.out.println(x+"@");
                                if(x<19){
                                    for(int i1=x;i1>0;i1--){
                                        for(int j1=0;j1<test[x].length;j1++){
                                            test[i1][j1]=test[i1-1][j1];
                                        }
                                    }
                                }

                            }
                        }

                        createShape();
                        return false;
                    }else {
                        break;
                    }
                }
            }
        }

        return true;
    }
}

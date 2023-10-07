package ShapeClass;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test extends JFrame implements ActionListener {
    public test() {
        initJFrame();
        Timer timer = new Timer(1000, this); // 创建定时器，每秒触发一次
        timer.start();
        this.setVisible(true);
    }

    public static void main(String[] args) {


        //new test();
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        System.out.println("nihao");
    }

    private void initJFrame() {
        // 设置界面的宽高
        this.setSize(480, 960);
        // 设置界面标题
        this.setTitle("游戏界面");
        // 设置界面置顶
        this.setAlwaysOnTop(true);
        // 设置界面居中
        this.setLocationRelativeTo(null);
        // 设置界面关闭形式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}

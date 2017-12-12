package gui.panel;

import javax.swing.*;
import java.awt.*;

public class CenterPanel extends JPanel{
    private double rate;//拉伸比例
    private JComponent c;//显示组件;
    private boolean stretch;//是否拉伸

    public CenterPanel(double rate, boolean stretch){
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }
    public CenterPanel(double rate){
       this(rate, true);
    }
    //调用updateui方法执行此方法
    @Override
    public void repaint() {
        super.repaint();
        if (null != c){
            Dimension containerSize = this.getSize();
            Dimension componentSize = c.getSize();
            if (stretch){
                c.setSize((int) (containerSize.width * rate), (int) (containerSize.height * rate));
            }else {
                c.setSize(componentSize);
            }
            c.setLocation(containerSize.width / 2 - c.getSize().width / 2,
                    containerSize.height / 2 - c.getSize().height / 2);
        }
    }

    public void show(JComponent c){
        this.c = c;
        Component[] cs = this.getComponents();//获取面板包含的组件
        for (Component temp : cs){
            remove(temp);
        }
        this.add(c);
        //从数据读取数据更新界面
        if (c instanceof WorkingPanel){
           ((WorkingPanel) c).updateData();
        }
        this.updateUI();

    }

    public static void main(String[] args) {

        JFrame f = new JFrame();
        f.setSize(200, 200);
        f.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(0.85,true);
        f.setContentPane(cp);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        JButton b  =new JButton("abc");
        cp.show(b);
        //JLabel l = new JLabel("测试");
       // cp.show(l);
    }
}

package gui.frame;

import gui.panel.MainPanel;

import javax.swing.*;

public class MainFrame extends JFrame{
    public static MainFrame instance = new MainFrame();

    public MainFrame(){
        this.setSize(500,450);
        this.setLocationRelativeTo(null);
        this.setTitle("账本");
        this.setResizable(false);//不可改变大小
        this.setContentPane(MainPanel.instance);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        instance.setVisible(true);
    }
}

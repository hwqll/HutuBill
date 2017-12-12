package gui.panel;

import gui.listener.ConfigListener;
import service.ConfigService;
import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;

public class ConfigPanel extends WorkingPanel{
    static {
        GUIUitl.useLNF();
    }
    public static ConfigPanel instance = new ConfigPanel();
    JLabel lBudget = new JLabel("本月预算(¥)");
    public  JTextField tfBudget = new JTextField("0");

    JLabel lMysql = new JLabel("安装目录");
    public JTextField tfMysqlPath = new JTextField("");

    public  JButton bsubmit = new JButton("更新");

    public ConfigPanel(){
        GUIUitl.setColor(ColorUtil.grayColor, lBudget, lMysql);
        GUIUitl.setColor(ColorUtil.blueColor, bsubmit);



        JPanel pinput = new JPanel();
        int gap = 40;
        pinput.setLayout(new GridLayout(4,1,gap, gap));
        pinput.add(lBudget);
        pinput.add(tfBudget);
        pinput.add(lMysql);
        pinput.add(tfMysqlPath);
        JPanel psubmit = new JPanel();
        psubmit.add(bsubmit);


        this.setLayout(new BorderLayout());
        this.add(pinput, BorderLayout.NORTH);
        this.add(psubmit, BorderLayout.CENTER);

        addListener();
    }

    public void addListener(){
        ConfigListener cl = new ConfigListener();
        bsubmit.addActionListener(cl);
    }

    @Override
    public void updateData() {
        String budget = new ConfigService().get(ConfigService.budget);
        String mysqlPath = new ConfigService().get(ConfigService.mysqlPath);
        tfBudget.setText(budget);
        tfMysqlPath.setText(mysqlPath);
        tfBudget.grabFocus();
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(ConfigPanel.instance);
    }
}

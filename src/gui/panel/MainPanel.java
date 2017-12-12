package gui.panel;

import gui.listener.ToolBarListener;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;

public class MainPanel extends JPanel{
    /**
     * 静态代码块会默认执行.
     */
    static {
        GUIUitl.useLNF();
    }
    public static MainPanel instance = new MainPanel();

    public JToolBar tb = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bBackup = new JButton();
    public JButton bRecover = new JButton();

    public CenterPanel workingPanel;

    private MainPanel(){
        GUIUitl.setImageIcon(bSpend, "home.png", "消费一览");
        GUIUitl.setImageIcon(bRecord, "record.png", "记一笔");
        GUIUitl.setImageIcon(bCategory, "category2.png", "消费分类");
        GUIUitl.setImageIcon(bReport, "report.png", "月消费报表");
        GUIUitl.setImageIcon(bConfig, "config.png", "设置");
        GUIUitl.setImageIcon(bBackup, "backup.png", "备份");
        GUIUitl.setImageIcon(bRecover, "restore.png", "恢复");

        tb.add(bSpend);
        tb.add(bRecord);
        tb.add(bCategory);
        tb.add(bReport);
        tb.add(bConfig);
        tb.add(bBackup);
        tb.add(bRecover);
        tb.setFloatable(false);

        workingPanel = new CenterPanel(0.85);
        setLayout(new BorderLayout());
        add(tb, BorderLayout.NORTH);
        add(workingPanel, BorderLayout.CENTER);

        addListener();
    }

    /**
     * 给工具栏按钮添加事件
     */
    private void addListener(){
        ToolBarListener toolBarListener = new ToolBarListener();
        bSpend.addActionListener(toolBarListener);
        bRecord.addActionListener(toolBarListener);
        bCategory.addActionListener(toolBarListener);
        bReport.addActionListener(toolBarListener);
        bConfig.addActionListener(toolBarListener);
        bBackup.addActionListener(toolBarListener);
        bRecover.addActionListener(toolBarListener);
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(MainPanel.instance, 1);
    }

}

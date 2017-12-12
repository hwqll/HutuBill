package gui.listener;

import gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolBarListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        MainPanel mp = MainPanel.instance;
        JButton b = (JButton) e.getSource();//获取点击的按钮。
        if (b == mp.bSpend){
            mp.workingPanel.show(SpendPanel.instance);
        }
        if (b == mp.bBackup){
            mp.workingPanel.show(BackupPanel.instance);
        }
        if (b == mp.bCategory){
            mp.workingPanel.show(CategoryPanel.instance);
        }
        if (b == mp.bConfig){
            mp.workingPanel.show(ConfigPanel.instance);
        }
        if (b == mp.bRecord){
            mp.workingPanel.show(RecordPanel.instance);
        }
        if (b == mp.bReport){
            mp.workingPanel.show(ReportPanel.instance);
        }
        if (b == mp.bRecover){
            mp.workingPanel.show(RecoverPanel.instance);
        }

    }
}

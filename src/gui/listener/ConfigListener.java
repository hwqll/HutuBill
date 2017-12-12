package gui.listener;

import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUitl;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class ConfigListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigPanel p = ConfigPanel.instance;
        if (!GUIUitl.checkNumber(p.tfBudget, "本月预算")){
            return;
        }
        String mysqlPath = p.tfMysqlPath.getText();
       // int i = mysqlPath.length();
        if (0 != mysqlPath.length()){
            //String s = String.format("%s/%s", mysqlPath, "bin/mysql");
            File file = new File(mysqlPath, "/bin/mysql");
            if (!file.exists()){
                JOptionPane.showMessageDialog(p, "mysql路径不正确");
                p.tfMysqlPath.grabFocus();
                return;
            }
        }

        //更新数据库
        ConfigService cs = new ConfigService();
        cs.update(ConfigService.budget, p.tfBudget.getText());
        cs.update(ConfigService.mysqlPath, p.tfMysqlPath.getText());
        JOptionPane.showMessageDialog(p, "设置修改成功");
    }
}

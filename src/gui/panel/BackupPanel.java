package gui.panel;

import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;

public class BackupPanel extends JPanel{
    static {
        GUIUitl.useLNF();
    }
    public static BackupPanel instance = new BackupPanel();

    JButton bbackup = new JButton("备份");
    private BackupPanel(){
        GUIUitl.setColor(ColorUtil.blueColor, bbackup);
        this.add(bbackup);
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(BackupPanel.instance);
    }
}

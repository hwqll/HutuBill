package gui.panel;


import util.ChartUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;

public class ReportPanel extends JPanel{
    static {
        GUIUitl.useLNF();
    }
    public static ReportPanel instance = new ReportPanel();
    public JLabel jLabel;
    public ReportPanel(){
        jLabel = new JLabel();
        Image image = ChartUtil.getImage(400, 300);
        ImageIcon imageIcon = new ImageIcon(image);
        jLabel.setIcon(imageIcon);
        this.setLayout(new BorderLayout());
        this.add(jLabel, BorderLayout.CENTER);

    }

    public static void main(String[] args) {

        GUIUitl.showPanel(ReportPanel.instance);
    }
}

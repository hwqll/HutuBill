package gui.panel;
import util.CircleProgressBar;
import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TestPanel {
    public static void main(String[] args) {

        GUIUitl.useLNF();
//        JPanel p = new JPanel();
//        p.add(new JButton("按钮1"));
//        p.add(new JButton("按钮2"));
//        GUIUitl.showPanel(p);
        JPanel p = new JPanel();
        CircleProgressBar circleProgressBar = new CircleProgressBar();
        circleProgressBar.setBackgroundColor(ColorUtil.blueColor);
        circleProgressBar.setProgress(0);
        JButton jButton = new JButton("点击");
        p.setLayout(new BorderLayout());
        p.add(circleProgressBar, BorderLayout.CENTER);
        p.add(jButton, BorderLayout.SOUTH);
        GUIUitl.showPanel(p);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //后台重新开一个线程渲染
                new SwingWorker(){
                    @Override
                    protected Object doInBackground() throws Exception {
                        for (int i = 0; i < 100; i++) {
                            circleProgressBar.setProgress(i + 1);
                            circleProgressBar.setForegroundColor(ColorUtil.getByPercentage(i + 1));
                            try {
                                Thread.sleep(100);
                            } catch (InterruptedException e1) {
                                // TODO Auto-generated catch block
                                e1.printStackTrace();
                            }
                        }
                        return null;
                    }

                }.execute();
            }
        });
    }
}

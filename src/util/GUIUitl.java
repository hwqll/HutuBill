package util;

import gui.panel.CenterPanel;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class GUIUitl {
    //图片路径
    private static String imageFolder = "img";
    /**
     * 校验输入框的内容是否为空。
     */
    public static boolean checkEmpty(JTextField tf, String input){
        String text = tf.getText().trim();
        if (0 == text.length()){
            JOptionPane.showMessageDialog(null, input + "不能为空!");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    /**
     * 校验组件是否为数字格式
     */
    public static boolean checkNumber(JTextField tf, String input){
        if (!checkEmpty(tf, input)){
            return false;
        }
        String text = tf.getText().trim();
        try {
            Integer.parseInt(text);
            return true;
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(null, input + "需为数字");
            tf.grabFocus();
            e.printStackTrace();
            return false;
        }
    }
    /**
     * 校验是否为空
     */
    public static boolean checkZero(JTextField tf, String input){
        if (!checkEmpty(tf, input)){
            return false;
        }
        String text = tf.getText().trim();
        if (0 == Integer.parseInt(text)){
            JOptionPane.showMessageDialog(null, input + "不能为零");
            tf.grabFocus();
            return false;
        }
        return true;
    }
    /**
     * 给多个组件设置前景色
     */
    public static void setColor(Color color, JComponent...cs){
        for (JComponent c: cs){
            c.setForeground(color);
        }
    }
    /**
     * 给按钮设置图标和文本以及提示文字
     */
    public static void setImageIcon(JButton b, String fileName, String tip){

        ImageIcon imageIcon = new ImageIcon(new File(imageFolder, fileName).getAbsolutePath());
        b.setIcon(imageIcon);
        b.setPreferredSize(new Dimension(61, 81));
        b.setToolTipText(tip);
        //设置文字相对于图标位置
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }
    /**
     * 设置皮肤:使用第三方jar包
     */
    public static void useLNF(){
        //这句话必须加在第一行才能保证生效
        try {
            javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param p
     * @param stretch 拉伸比例
     */
    public static void showPanel(JPanel p, double stretch){
        useLNF();
        JFrame jFrame = new JFrame();
        jFrame.setSize(500,500);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        CenterPanel cp = new CenterPanel(stretch);
        jFrame.setContentPane(cp);
        jFrame.setVisible(true);
        cp.show(p);
    }
    public static void showPanel(JPanel p){
        showPanel(p, 0.85);
    }
}


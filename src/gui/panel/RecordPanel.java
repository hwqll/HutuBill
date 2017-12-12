package gui.panel;

import gui.model.CategoryComboxModel;
import org.jdesktop.swingx.JXDatePicker;
import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class RecordPanel extends JPanel{
    static {
        GUIUitl.useLNF();
    }
    public static RecordPanel instance = new RecordPanel();

    JLabel lSpend = new JLabel("花费(¥)");
    JLabel lCategory = new JLabel("分类");
    JLabel lComment = new JLabel("备注");
    JLabel lDate = new JLabel("日期");

    public JTextField tf = new JTextField("0");
    public CategoryComboxModel cbModel = new CategoryComboxModel();
    public JComboBox<String> cbCategory = new JComboBox<>(cbModel);
    public JTextField tfComment = new JTextField();
    public JXDatePicker datepick = new JXDatePicker(new Date());
    JButton bSubmit = new JButton("记一笔");

    public RecordPanel(){
        GUIUitl.setColor(ColorUtil.grayColor, lSpend, lCategory, lComment, lDate);
        GUIUitl.setColor(ColorUtil.blueColor, bSubmit);

        JPanel pinput = new JPanel();
        JPanel psubmit = new JPanel();
        int gap = 40;//组件之间水平和垂直方向间隔
        pinput.setLayout(new GridLayout(4, 2, gap, gap));
        pinput.add(lSpend);
        pinput.add(tf);
        pinput.add(lCategory);
        pinput.add(cbCategory);
        pinput.add(lComment);
        pinput.add(tfComment);
        pinput.add(lDate);
        pinput.add(datepick);

        psubmit.add(bSubmit);
        //布局方式
        this.setLayout(new BorderLayout());
        this.add(pinput, BorderLayout.NORTH);
        this.add(psubmit, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        GUIUitl.showPanel(RecordPanel.instance);
    }
}

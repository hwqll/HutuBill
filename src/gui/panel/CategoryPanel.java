package gui.panel;

import entity.Category;
import gui.listener.CategoryListener;
import gui.model.CategoryTableModel;
import service.CategoryService;
import util.ColorUtil;
import util.GUIUitl;

import javax.swing.*;
import java.awt.*;

public class CategoryPanel extends WorkingPanel{
    static {
        GUIUitl.useLNF();
    }
    public static CategoryPanel instance = new CategoryPanel();
    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    CategoryTableModel ctm = new CategoryTableModel();
    public JTable t = new JTable(ctm);
    public JScrollPane p = new JScrollPane(t);

    public JPanel pSubmit = new JPanel();

    public CategoryPanel(){
        GUIUitl.setColor(ColorUtil.blueColor, bAdd, bEdit, bDelete);


        pSubmit.add(bAdd);
        pSubmit.add(bEdit);
        pSubmit.add(bDelete);

        this.setLayout(new BorderLayout());
        this.add(p, BorderLayout.CENTER);
        this.add(pSubmit, BorderLayout.SOUTH);

        addListener();
    }

    /**
     * 获取表格中选中的category
     * @return
     */
    public Category getSelectedCategory(){
        int index = t.getSelectedRow();
        if (index < 0){
            JOptionPane.showMessageDialog(p, "没有选择某行");
            return null;
        }
        return ctm.cs.get(index);
    }

    public void updateData() {
        ctm.cs = new CategoryService().list();
        t.updateUI();
        t.getSelectionModel().setSelectionInterval(0, 0);

        if(0==ctm.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }
        else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }
    }

    public void addListener(){
        CategoryListener cl = new CategoryListener();
        bAdd.addActionListener(cl);
        bEdit.addActionListener(cl);
        bDelete.addActionListener(cl);
    }
    public static void main(String[] args) {
        GUIUitl.showPanel(CategoryPanel.instance);
    }

}

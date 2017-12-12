package gui.listener;

import entity.Category;
import gui.panel.CategoryPanel;
import service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CategoryListener implements ActionListener{
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel p = CategoryPanel.instance;
        JButton b = (JButton)e.getSource();
        if (b == p.bAdd){
            String name = JOptionPane.showInputDialog(null);//弹出输入对话框
            if (0 == name.length()){
                JOptionPane.showMessageDialog(p, "分类名不能为空");
                return;
            }
            new CategoryService().add(name);
            JOptionPane.showMessageDialog(p, "添加成功.");
        }
        if (b == p.bEdit){
            Category c = p.getSelectedCategory();
            if (c == null){
                return;
            }
            int id = c.id;
            String name = JOptionPane.showInputDialog("修改分类名",c.name);
            if (0 == name.length()){
                JOptionPane.showMessageDialog(p, "分类名不能为空");
                return;
            }
            new CategoryService().update(id, name);
            JOptionPane.showMessageDialog(p, "修改成功.");
        }
        if (b == p.bDelete){
            Category c = p.getSelectedCategory();
            int cid = c.id;
            if (c.recordNumber != 0){
                JOptionPane.showMessageDialog(p, "本分类有消费记录存在, 不能删除");
                return;
            }
            if (JOptionPane.OK_OPTION != JOptionPane.showConfirmDialog(p, "确定要删除？")){
                return;
            }
            new CategoryService().delete(cid);
            JOptionPane.showMessageDialog(p, "删除成功.");
        }
    }
}

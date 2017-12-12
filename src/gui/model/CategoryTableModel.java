package gui.model;

import entity.Category;
import service.CategoryService;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import java.util.ArrayList;
import java.util.List;

public class CategoryTableModel implements TableModel{

    public List<Category> cs =new  CategoryService().list();
    String[] columnNames = new String[]{"分类名称","消费一览"};

    public CategoryTableModel(){
//        cs.add("餐饮");
//        cs.add("交通");
//        cs.add("住宿");
//        cs.add("话费");

    }

    /**
     * 获取指定行列的值
     * @param rowIndex
     * @param columnIndex
     * @return
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Category category = cs.get(rowIndex);
        if (0 == columnIndex){
            return category.name;
        }else {
            return category.recordNumber;
        }
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {

    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public int getRowCount() {
        return cs.size();
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
}

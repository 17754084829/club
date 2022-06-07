package club.weight.element.table;

import club.weight.element.Eelement;
import club.weight.element.dialog.DialogClubInfo;
import com.mysql.jdbc.StringUtils;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;
import javax.swing.text.html.parser.Element;
import java.util.List;
import java.awt.*;


class TableModel extends AbstractTableModel{
    private List<List<String>> data;
    private List<String> title;
    private int size;
    public TableModel(List<String> title,List<List<String>> data){
        this.data=data;
        this.title=title;
        this.size=data.size();
    }
    public int getRowCount() {
        if(data==null){
            return 0;
        }
        return size;
    }

    public int getColumnCount() {
        return title.size();
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if(rowIndex>=data.size()||columnIndex>=title.size()){
            return "";
        }
        return data.get(rowIndex).get(columnIndex);
    }

    @Override
    public String getColumnName(int column) {
        return title.get(column);
    }
    public void updateData(List<String> title,List<List<String>> data){
        this.title=title;
        this.data=data;
        this.size=data.size();
    }
}

/**
 * table 控件
 *
 * */
public class Table extends Eelement {
    private TableModel tableModel;
    private JTable jTable;
    public Table(String windowsName,List<List<String>> data){
        f = new JFrame(windowsName);
        f.setSize(1000, 500);
        f.setLocation(500, 300);
        f.setLayout(new BorderLayout());
        tableModel=new TableModel(data.get(0),data.subList(1,data.size()));
        JTable t = new JTable(tableModel);
        t.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                int rowIndex=t.getSelectedRow();
                if(rowIndex<0){
                    return;
                }
                String id=(String)t.getModel().getValueAt(rowIndex,0);
                DialogClubInfo clubInfo=new DialogClubInfo("社团信息",id);
                clubInfo.show();
            }
        });
        jTable=t;
        // 根据t创建 JScrollPane
        JScrollPane sp = new JScrollPane(t);

        //或则创建一个空的JScrollPane，再通过setViewportView把table放在JScrollPane中
        // JScrollPane sp = new JScrollPane(t);
        // sp.setViewportView(t);

        // 把sp而非JTable加入到JFrame上，
        f.add(sp, BorderLayout.CENTER);

        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void updateTableData(List<List<String>> data,String windowsName){
        this.tableModel=new TableModel(data.get(0),data.subList(1,data.size()));
        this.jTable.setModel(tableModel);
        this.jTable.updateUI();
        if(!StringUtils.isNullOrEmpty(windowsName)){
            f.setTitle(windowsName);
        }
    }
}

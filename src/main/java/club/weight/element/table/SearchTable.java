package club.weight.element.table;

import club.model.ClubInfo;
import club.model.ClubMember;
import club.model.Teacher;
import club.service.ClubInfoService;
import club.service.ClubMemberService;
import club.service.TeacherService;
import club.util.MyContext;
import club.weight.element.Eelement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
public class SearchTable extends Eelement implements ActionListener{
    private Table table;
    private JTextField sid;
    private JTextField sname;
    public SearchTable(Table table){
        f=table.f;
        this.table=table;
        JComboBox<String> jComboBox=new JComboBox<String>(new String[]{"社团","老师","成员"});
        jComboBox.addActionListener(this);
        JPanel j=new JPanel();
        JLabel id = new JLabel("id");
        sid = new JTextField("");
        JLabel name = new JLabel("名称");
        sname = new JTextField("");
        JButton bsearch = new JButton("搜索");
        sid.setPreferredSize(new Dimension(80, 30));
        sname.setPreferredSize(new Dimension(80, 30));
        j.add(jComboBox);
        j.add(id);
        j.add(sid);
        j.add(name);
        j.add(sname);
        j.add(bsearch);
        bsearch.addActionListener(this);
        f.add(j, BorderLayout.NORTH);
    }
    public void update(List<List<String>> data,String windowsName){
        this.table.updateTableData(data,windowsName);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() instanceof JButton){
            String id=sid.getText().toString();
            String name=sname.getText().toString();
            this.search(f.getTitle(),id,name);
        }
        else if(e.getSource() instanceof JComboBox){
            JComboBox jComboBox=(JComboBox)e.getSource();
            this.search(jComboBox.getSelectedItem().toString(),null,null);
        }
    }
    private<T> T getTargetObject(Class<T> t, String id,String name){
        T t1=MyContext.newObject(t,id,name);
        return t1;
    }
    private void search(String title,String id,String name){
        int code="社团".equals(title)?1:("老师".equals(title)?2:3);
        switch (code){
            case 1:{
                ClubInfoService clubInfoService=MyContext.getObject(ClubInfoService.class);
                this.update(MyContext.getModelList(ClubInfo.class,clubInfoService.getList(this.getTargetObject(ClubInfo.class,id,name))),"社团");
            };break;
            case 2: {
                TeacherService teacherService=MyContext.getObject(TeacherService.class);
                this.update(MyContext.getModelList(Teacher.class,teacherService.getList(this.getTargetObject(Teacher.class,id,name))),"老师");
            };break;
            default: {
                ClubMemberService clubMemberService=MyContext.getObject(ClubMemberService.class);
                this.update(MyContext.getModelList(ClubMember.class,clubMemberService.getList(this.getTargetObject(ClubMember.class,id,name))),"成员");
            };break;
        }
    }
}

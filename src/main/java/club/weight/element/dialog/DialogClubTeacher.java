package club.weight.element.dialog;

import club.model.ClubInfo;
import club.model.ClubMember;
import club.model.Teacher;
import club.service.ClubInfoService;
import club.service.ClubMemberService;
import club.service.TeacherService;
import club.util.GenerateID;
import club.util.MyContext;
import club.weight.element.Eelement;
import com.mysql.jdbc.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

public class DialogClubTeacher extends Eelement {
    private DialogClubTeacher thisPtr=null;
    public DialogClubTeacher(String title, final String id){
        f=new JFrame(title);
        thisPtr=this;
        f.setSize(400,300);
        f.setLocation(200,300);
        f.setResizable(false);
        f.setLayout(new FlowLayout());
        JLabel nameTitle=new JLabel("名字");
        final JTextField nameFlid=new JTextField();
        nameFlid.setColumns(28);
        JLabel birthTitle=new JLabel("出生日期");
        final JTextField birthFiled=new JTextField();
        birthFiled.setColumns(28);
        JLabel sexTitle=new JLabel("性别");
        final JTextField sexFiled=new JTextField();
        sexFiled.setColumns(28);
        JLabel clubname=new JLabel("社团名称");
        List<String> list=MyContext.getObject(ClubInfoService.class).getListClubName();
        String[] arr=new String[list.size()];
        int index=0;
        for (String item:list){
            arr[index]=item;
            index++;
        }
        JLabel jLabel=new JLabel();
        jLabel.setSize(100,0);
        final JComboBox<String> jComboBox=new JComboBox<String>(arr);
        jComboBox.setSize(20,100);
        JButton add=new JButton("新增");
        add.setSize(20,20);
        JButton update=new JButton("修改");
        update.setSize(20,20);
        JButton del=new JButton("删除");
        del.setSize(20,20);
        f.add(nameTitle);
        f.add(nameFlid);
        f.add(birthTitle);
        f.add(birthFiled);
        f.add(sexTitle);
        f.add(sexFiled);
        f.add(clubname);
        f.add(jComboBox);
        f.add(jLabel);
        f.add(add);
        if(!StringUtils.isNullOrEmpty(id)){
            f.add(update);
            f.add(del);
        }
        add.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher=new Teacher();
                teacher.setId(GenerateID.getTeacherId());
                teacher.setName(nameFlid.getText().toString());
                teacher.setBirthday(birthFiled.getText().toString());
                teacher.setSex(sexFiled.getText().toString());
                ClubInfo query =new ClubInfo();
                query.setName(jComboBox.getSelectedItem().toString());
                teacher.setClub_id(MyContext.getObject(ClubInfoService.class).getList(query).get(0).getId());
                teacher.setDel_flag("N");
                MyContext.getObject(TeacherService.class).saveOrUpdate(teacher);
                JOptionPane.showMessageDialog(null,"添加成功");
                thisPtr.close();
            }
        });
        del.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher=new Teacher();
                teacher.setId(id);
                teacher.setDel_flag("Y");
                MyContext.getObject(TeacherService.class).saveOrUpdate(teacher);
                JOptionPane.showMessageDialog(null,"删除成功");
                thisPtr.close();
            }
        });
        update.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Teacher teacher=new Teacher();
                teacher.setId(id);
                teacher.setName(nameFlid.getText().toString());
                teacher.setBirthday(birthFiled.getText().toString());
                teacher.setSex(sexFiled.getText().toString());
                ClubInfo query =new ClubInfo();
                query.setName(jComboBox.getSelectedItem().toString());
                teacher.setClub_id(MyContext.getObject(ClubInfoService.class).getList(query).get(0).getId());
                teacher.setDel_flag("N");
                MyContext.getObject(TeacherService.class).saveOrUpdate(teacher);
                JOptionPane.showMessageDialog(null,"更新成功");
                thisPtr.close();
            }
        });
        Teacher teacher=null;
        if(!StringUtils.isNullOrEmpty(id)){
            teacher=new Teacher();
            teacher.setId(id);
            teacher=MyContext.getObject(TeacherService.class).getList(teacher).get(0);
            nameFlid.setText(teacher.getName());
            birthFiled.setText(teacher.getBirthday());
            sexFiled.setText(teacher.getSex());
            jComboBox.setSelectedItem(teacher.getClub_name());
        }
    }

    @Override
    public void close() {
        super.close();
        super.shutDown();
    }
}



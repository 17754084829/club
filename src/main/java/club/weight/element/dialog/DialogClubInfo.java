package club.weight.element.dialog;

import club.model.ClubInfo;
import club.service.ClubInfoService;
import club.util.GenerateID;
import club.util.MyContext;
import club.weight.element.Eelement;
import com.mysql.jdbc.StringUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class DialogClubInfo extends Eelement {
    public DialogClubInfo(String title,String id){
        f=new JFrame(title);
        f.setSize(400,300);
        f.setLocation(100,100);
        f.setResizable(false);
        f.setLayout(new FlowLayout());
        JLabel nameTitle=new JLabel("名称");
        JTextField nameFlid=new JTextField();
        nameFlid.setColumns(28);
        JLabel birthTitle=new JLabel("成立时间");
        JTextField birthFiled=new JTextField();
        birthFiled.setColumns(28);
        JLabel descTitle=new JLabel("描述");
        JButton add=new JButton("新增");
        add.setSize(20,20);
        JButton update=new JButton("修改");
        update.setSize(20,20);
        JButton del=new JButton("删除");
        del.setSize(20,20);
        JTextField descFild=new JTextField();
        descFild.setColumns(28);
        f.add(nameTitle);
        f.add(nameFlid);
        f.add(birthTitle);
        f.add(birthFiled);
        f.add(descTitle);
        f.add(descFild);
        f.add(add);
        f.add(update);
        f.add(del);
        add.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ClubInfo clubInfo=new ClubInfo();
                GenerateID.getClubInfoId();
                clubInfo.setId(GenerateID.getClubInfoId());
                clubInfo.setName(nameFlid.getText().toString());
                clubInfo.setClub_found_time(birthFiled.getText().toString());
                clubInfo.setDesc(descFild.getText().toString());
                clubInfo.setDel_flag("N");
                MyContext.getObject(ClubInfoService.class).saveOrUpdate(clubInfo);
            }
        });
       ClubInfo clubInfo=null;
       if(!StringUtils.isNullOrEmpty(id)){
           clubInfo=new ClubInfo();
           clubInfo.setId(id);
           clubInfo=MyContext.getObject(ClubInfoService.class).getList(clubInfo).get(0);
           nameFlid.setText(clubInfo.getName());
           birthFiled.setText(clubInfo.getClub_found_time());
           descFild.setText(clubInfo.getDesc());
       }
    }

    @Override
    public void close() {
        super.close();
        super.shutDown();
    }
}

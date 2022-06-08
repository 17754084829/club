package club.model;

import club.annonation.DescFiled;

/**
 * 老师信息
 * **/
public class Teacher {
    //老师id
    @DescFiled("老师id")
    private String id;
    //老师名称
    @DescFiled("老师名称")
    private String name;
    //社团id
    private String club_id;
    //性别
    @DescFiled("性别")
    private String sex;
    //生日
    @DescFiled("生日")
    private String birthday;
    //是否删除
    private String del_flag;
    @DescFiled("社团名称")
    private String club_name;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    public String getClub_name() {
        return club_name;
    }

    public void setClub_name(String club_name) {
        this.club_name = club_name;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", club_id='" + club_id + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", del_flag='" + del_flag + '\'' +
                ", club_name='" + club_name + '\'' +
                '}';
    }
}

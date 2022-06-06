package club.model;
/**
 * 社团成员信息
 * */
public class ClubMember {
    //成员id
    private String id;
    //成员名称
    private String name;
    //成员性别
    private String sex;
    //成员生日
    private String birthday;
    //社团id
    private String club_id;
    //是否删除
    private String del_flag;

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

    public String getClub_id() {
        return club_id;
    }

    public void setClub_id(String club_id) {
        this.club_id = club_id;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "ClubMember{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", club_id='" + club_id + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }
}

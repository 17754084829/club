package club.model;

/**
 * 社团信息
 * */
public class ClubInfo {
    //社团id
    private String id;
    //社团名称
    private String name;
    //指导老师id
    private String teacher_id;
    //社团成员
    private String club_member_id;
    //社团成立时间
    private String club_found_time;
    //社团描述
    private String desc;
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

    public String getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(String teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getClub_member_id() {
        return club_member_id;
    }

    public void setClub_member_id(String club_member_id) {
        this.club_member_id = club_member_id;
    }

    public String getClub_found_time() {
        return club_found_time;
    }

    public void setClub_found_time(String club_found_time) {
        this.club_found_time = club_found_time;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDel_flag() {
        return del_flag;
    }

    public void setDel_flag(String del_flag) {
        this.del_flag = del_flag;
    }

    @Override
    public String toString() {
        return "ClubInfo{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", teacher_id='" + teacher_id + '\'' +
                ", club_member_id='" + club_member_id + '\'' +
                ", club_found_time='" + club_found_time + '\'' +
                ", desc='" + desc + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }
}

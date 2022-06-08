package club.model;

import club.annonation.DescFiled;

/**
 * 社团信息
 * */
public class ClubInfo {
    //社团id
    @DescFiled("社团id")
    private String id;
    //社团名称
    @DescFiled("社团名称")
    private String name;
    //社团成立时间
    @DescFiled("社团成立时间")
    private String club_found_time;
    //社团描述
    @DescFiled("社团描述")
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
                ", club_found_time='" + club_found_time + '\'' +
                ", desc='" + desc + '\'' +
                ", del_flag='" + del_flag + '\'' +
                '}';
    }
}

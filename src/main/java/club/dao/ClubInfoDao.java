package club.dao;

import club.model.ClubInfo;

import java.util.List;

public interface ClubInfoDao {
    //插入一条数据
    int insertOne(ClubInfo clubInfo);
    //更新数据
    int updateOne(ClubInfo clubInfo);
    //通过条件获取数据
    List<ClubInfo> getList(ClubInfo clubInfo);
    //获取所有社团名称
    List<String> getListClubName();
}

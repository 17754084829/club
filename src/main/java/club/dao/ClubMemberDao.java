package club.dao;

import club.model.ClubMember;

import java.util.List;

public interface ClubMemberDao {
    //插入一条数据
    int insertOne(ClubMember clubMember);
    //更新数据
    int updateOne(ClubMember clubMember);
    //通过条件获取数据
    List<ClubMember> getList(ClubMember clubMember);
}

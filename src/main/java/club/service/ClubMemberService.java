package club.service;

import club.dao.ClubMemberDao;
import club.dao.TeacherDao;
import club.model.ClubMember;
import club.model.Teacher;
import club.util.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClubMemberService {
    private SqlSession sqlSession;
    private ClubMemberDao clubMemberDao;
    public ClubMemberService(){
        sqlSession= MybatiesUtils.getSqlSession();
        clubMemberDao=sqlSession.getMapper(ClubMemberDao.class);
    }

    public int saveOrUpdate(ClubMember clubMember){
        ClubMember query=new ClubMember();
        query.setId(clubMember.getId());
        List<ClubMember> clubInfos= clubMemberDao.getList(query);
        int rs=0;
        if(clubInfos!=null&&clubInfos.size()>0){
            rs=clubMemberDao.updateOne(clubMember);
            sqlSession.commit();
        }else{
            rs=clubMemberDao.insertOne(clubMember);
            sqlSession.commit();
        }
        return rs;
    }
    public List<ClubMember> getList(ClubMember clubMember){
        return clubMemberDao.getList(clubMember);
    }
}

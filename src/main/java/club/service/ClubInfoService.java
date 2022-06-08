package club.service;

import club.dao.ClubInfoDao;
import club.model.ClubInfo;
import club.util.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class ClubInfoService {
    private SqlSession sqlSession;
    private ClubInfoDao clubInfoDao;
    public ClubInfoService(){
        sqlSession= MybatiesUtils.getSqlSession();
        clubInfoDao=sqlSession.getMapper(ClubInfoDao.class);
    }

    public int saveOrUpdate(ClubInfo clubInfo){
        ClubInfo query=new ClubInfo();
        query.setId(clubInfo.getId());
        List<ClubInfo> clubInfos= clubInfoDao.getList(query);
        int rs=0;
        if(clubInfos!=null&&clubInfos.size()>0){
            rs=clubInfoDao.updateOne(clubInfo);
            sqlSession.commit();
        }else{
            rs=clubInfoDao.insertOne(clubInfo);
            sqlSession.commit();
        }
        return rs;
    }
    public List<ClubInfo> getList(ClubInfo clubInfo){
        List<ClubInfo> list= clubInfoDao.getList(clubInfo);
        return list;
    }
}

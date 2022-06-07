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
        List<ClubInfo> clubInfos= clubInfoDao.getList(clubInfo);
        int rs=0;
        if(clubInfos!=null&&clubInfos.size()>0){
            rs=clubInfoDao.updateOne(clubInfo);
        }else{
            rs=clubInfoDao.insertOne(clubInfo);
        }
        return rs;
    }
    public List<ClubInfo> getList(ClubInfo clubInfo){
        List<ClubInfo> list= clubInfoDao.getList(clubInfo);
        return list;
    }
}

package club.service;

import club.dao.ClubInfoDao;
import club.dao.TeacherDao;
import club.model.ClubInfo;
import club.model.Teacher;
import club.util.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class TeacherService {
    private SqlSession sqlSession;
    private TeacherDao  teacherDao;
    public TeacherService(){
        sqlSession= MybatiesUtils.getSqlSession();
        teacherDao=sqlSession.getMapper(TeacherDao.class);
    }

    public int saveOrUpdate(Teacher teacher){
        Teacher query=new Teacher();
        query.setId(teacher.getId());
        List<Teacher> clubInfos= teacherDao.getList(query);
        int rs=0;
        if(clubInfos!=null&&clubInfos.size()>0){
            rs=teacherDao.updateOne(teacher);
            sqlSession.commit();
        }else{
            rs=teacherDao.insertOne(teacher);
            sqlSession.commit();
        }
        return rs;
    }
    public List<Teacher> getList(Teacher teacher){
        return teacherDao.getList(teacher);
    }
}

package club.main;

import club.dao.ClubInfoDao;
import club.dao.TeacherDao;
import club.model.ClubInfo;
import club.util.MybatiesUtils;
import org.apache.ibatis.session.SqlSession;

public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession= MybatiesUtils.getSqlSession();
        TeacherDao teacherDao=sqlSession.getMapper(TeacherDao.class);
        System.out.println(teacherDao.getList(null));
    }
}

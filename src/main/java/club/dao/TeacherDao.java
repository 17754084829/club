package club.dao;

import club.model.Teacher;

import java.util.List;

public interface TeacherDao {
    //插入一条数据
    int insertOne(Teacher teacher);
    //更新数据
    int updateOne(Teacher teacher);
    //通过条件获取数据
    List<Teacher> getList(Teacher teacher);
}

package club.util;

import club.annonation.DescFiled;
import club.dao.ClubInfoDao;
import club.service.ClubInfoService;
import club.service.ClubMemberService;
import club.service.TeacherService;
import com.mysql.jdbc.StringUtils;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyContext {
    private static Map<Class,Object> cacheObject;
    static {
        cacheObject=new HashMap<Class, Object>();
        cacheObject.put(ClubInfoService.class,new ClubInfoService());
        cacheObject.put(TeacherService.class,new TeacherService());
        cacheObject.put(ClubMemberService.class,new ClubMemberService());
    }
    //返回制定类型对象
    public static <T> T getObject(Class<T> clz){
        return clz.cast(cacheObject.get(clz));
    }
    //返回指定类型的所有列
    public static <T> List<String> getFlieds(Class<T> cls){
        List<String> rs=new ArrayList<String>();
        Field[] fields=cls.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            DescFiled descFiled=field.getAnnotation(DescFiled.class);
            if(descFiled==null){
                continue;
            }
            rs.add(descFiled.value());
        }
        return rs;
    }
    public static <T,S>List<List<String>> getModelList(Class<T> cls,List<S> list){
        return transFormList(getFlieds(cls),list);
    }
    private static<T> List<List<String>> transFormList(List<String> title,List<T> list){
        List<List<String>> rs=new ArrayList<List<String>>();
        rs.add(title);
        if(list==null){
            return rs;
        }
        for(T t:list){
            rs.add(getValue(t));
        }
        return rs;
    }
    //获取某个对象的desc注解对应的值
    private static <T> List<String> getValue(T obj){
        Class cls=obj.getClass();
        List<String> rs=new ArrayList<String>();
        Field[] fields=cls.getDeclaredFields();
        for(Field field:fields){
            field.setAccessible(true);
            DescFiled descFiled=field.getAnnotation(DescFiled.class);
            if(descFiled==null){
                continue;
            }
            try {
                rs.add((String) field.get(obj));
            }catch (Exception e){
                System.err.println(e.getMessage());
            }
        }
        return rs;
    }
    public static  <T> T newObject(Class<T> clz,String id,String name){
        T t=null;
        try {
            t=clz.cast(clz.newInstance());
            Field idF=clz.getDeclaredField("id");
            Field nameF=clz.getDeclaredField("name");
            Field delFlag=clz.getDeclaredField("del_flag");
            delFlag.setAccessible(true);
            idF.setAccessible(true);
            nameF.setAccessible(true);
            if(!StringUtils.isNullOrEmpty(id)){
                idF.set(t,id);
            }
            if(!StringUtils.isNullOrEmpty(name)) {
                nameF.set(t, name);
            }
            delFlag.set(t,"N");
        }catch (Exception e){
            System.err.println(e.getMessage());
        }
        return t;
    }
}

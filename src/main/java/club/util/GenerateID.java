package club.util;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.SimpleTimeZone;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.SimpleFormatter;

public class GenerateID {
    private static AtomicLong clubInfoLong=new AtomicLong();
    private static AtomicLong teacherLong=new AtomicLong();
    private static AtomicLong memberLong=new AtomicLong();
    private static SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
    /**
     * 获得一个社团id
     * @return String UUID
     */
    public static String getClubInfoId(){
        String key="clubinfo";
        StringBuilder stringBuilder=new StringBuilder(key);
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append(clubInfoLong.getAndAdd(1));
        return stringBuilder.toString();
    }
    /**
     * 获得一个老师id
     * @return String UUID
     */
    public static String getTeacherId(){
        String key="teacher";
        StringBuilder stringBuilder=new StringBuilder(key);
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append(teacherLong.getAndAdd(1));
        return stringBuilder.toString();
    }

    /**
     * 获得一个成员id
     * @return String UUID
     */
    public static String getClubMemberId(){
        String key="member";
        StringBuilder stringBuilder=new StringBuilder(key);
        stringBuilder.append(simpleDateFormat.format(new Date()));
        stringBuilder.append(memberLong.getAndAdd(1));
        return stringBuilder.toString();
    }
}

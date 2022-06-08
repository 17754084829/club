package club.main;

import club.dao.ClubMemberDao;
import club.model.ClubInfo;
import club.model.ClubMember;
import club.model.Teacher;
import club.service.ClubInfoService;
import club.util.MyContext;
import club.weight.element.table.SearchTable;
import club.weight.element.table.Table;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception{
        ClubInfoService service=MyContext.getObject(ClubInfoService.class);
        ClubInfo query=new ClubInfo();
        query.setDel_flag("N");
        List<List<String>> list=MyContext.getModelList(ClubInfo.class,service.getList(query));
        Table table=new Table("社团",list);
        SearchTable searchTable=new SearchTable(table);
        searchTable.show();
    }
}

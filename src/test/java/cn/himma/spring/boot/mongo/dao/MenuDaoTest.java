/**
 * 
 */
package cn.himma.spring.boot.mongo.dao;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;

import cn.himma.spring.boot.BaseTest;
import cn.himma.spring.boot.mongo.entity.MenuEntity;

public class MenuDaoTest extends BaseTest {
    @Autowired
    private IMenuDao dao;

    @Test
    @Rollback(true)
    public void testDelete() {
        dao.deleteAll();
    }

    @Test
    public void testInsert() {
        MenuEntity menu1 = new MenuEntity();
        menu1.setCode("project");
        menu1.setNameZh("父菜单1");
        menu1.setNameEn("parent one");
        menu1.setLevel(1);
        menu1.setSeq(1);

        MenuEntity menu2 = new MenuEntity();
        menu2.setCode("PAR_TWO");
        menu2.setNameZh("父菜单2");
        menu2.setNameEn("parent two");

        MenuEntity menu3 = new MenuEntity();
        menu3.setCode("PAR_THREE");
        menu3.setNameZh("父菜单3");
        menu3.setNameEn("parent three");

        MenuEntity menu4 = new MenuEntity();
        menu4.setParentCode("PAR_ONE");
        menu4.setCode("SUB_ONE");
        menu4.setNameZh("子菜单1");
        menu4.setNameEn("sub one");

        MenuEntity menu5 = new MenuEntity();
        menu5.setParentCode("PAR_ONE");
        menu5.setCode("SUB_TWO");
        menu5.setNameZh("子菜单2");
        menu5.setNameEn("sub two");

        MenuEntity menu6 = new MenuEntity();
        menu6.setParentCode("PAR_TWO");
        menu6.setCode("SUB_ONE");
        menu6.setNameZh("子菜单1");
        menu6.setNameEn("sub one");

        MenuEntity menu7 = new MenuEntity();
        menu7.setParentCode("PAR_TWO");
        menu7.setCode("SUB_TWO");
        menu7.setNameZh("子菜单2");
        menu7.setNameEn("sub two");

        List<MenuEntity> menuEntities = new ArrayList<MenuEntity>();
        menuEntities.add(menu1);
        menuEntities.add(menu2);
        menuEntities.add(menu3);
        menuEntities.add(menu4);
        menuEntities.add(menu5);
        menuEntities.add(menu6);
        menuEntities.add(menu7);
        dao.insert(menuEntities);
    }
}

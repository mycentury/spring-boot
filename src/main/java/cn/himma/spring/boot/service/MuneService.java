/**
 * 
 */
package cn.himma.spring.boot.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import cn.himma.spring.boot.mongo.dao.IMenuDao;
import cn.himma.spring.boot.mongo.entity.MenuEntity;
import cn.himma.spring.boot.vo.MenuVo;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年10月11日
 * @ClassName MuneBizImpl
 */
@Service
public class MuneService {
    @Autowired
    private IMenuDao menuDao;

    private List<MenuVo> menuVos;

    public List<MenuVo> getMenuVos() {
        if (CollectionUtils.isEmpty(menuVos)) {
            menuVos = queryAllMenus();
        }
        return new ArrayList<MenuVo>(menuVos);
    }

    private List<MenuVo> queryAllMenus() {
        List<MenuVo> menuVos = new ArrayList<MenuVo>();
        List<MenuEntity> menuEntities = menuDao.findAll();
        for (MenuEntity menuEntity : menuEntities) {
            if (menuEntity.getLevel() == 1) {
                MenuVo menuVo = new MenuVo();
                BeanUtils.copyProperties(menuEntity, menuVo);
                assembleSubMenuList(menuVo, menuEntities);
                menuVos.add(menuVo);
            }
        }
        return menuVos;
    }

    /**
     * @param menuVo
     * @param menuEntities
     */
    private void assembleSubMenuList(MenuVo menuVo, List<MenuEntity> menuEntities) {
        List<MenuVo> subMenus = menuVo.getSubMenus();
        if (CollectionUtils.isEmpty(subMenus)) {
            subMenus = new ArrayList<MenuVo>();
        }
        for (MenuEntity menuEntity : menuEntities) {
            if (menuEntity.getParentCode().equals(menuVo.getCode())) {
                MenuVo subMenu = new MenuVo();
                BeanUtils.copyProperties(menuEntity, subMenu);
                assembleSubMenuList(subMenu, menuEntities);
                subMenus.add(subMenu);
            }
        }
    }
}

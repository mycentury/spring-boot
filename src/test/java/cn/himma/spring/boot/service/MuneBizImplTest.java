/**
 * 
 */
package cn.himma.spring.boot.service;

import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import cn.himma.spring.boot.BaseTest;
import cn.himma.spring.boot.vo.MenuVo;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年10月11日
 * @ClassName MuneBizImplTest
 */
public class MuneBizImplTest extends BaseTest {

    @Autowired
    private MuneService muneService;

    /**
     * Test method for {@link cn.himma.spring.boot.service.MuneBizImpl#queryAllMenus()}.
     */
    @Test
    public void testQueryAllMenus() {
        List<MenuVo> menuVos = muneService.getMenuVos();
        System.out.println(menuVos);
    }

}

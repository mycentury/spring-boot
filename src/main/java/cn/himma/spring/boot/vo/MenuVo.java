/**
 * 
 */
package cn.himma.spring.boot.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年10月10日
 * @ClassName MenuVo
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuVo {
    private String code;
    private String nameZh;
    private String nameEn;
    private List<MenuVo> subMenus;
}

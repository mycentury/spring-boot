/**
 * 
 */
package cn.himma.spring.boot.mongo.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年10月10日
 * @ClassName MenuVo
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Document(collection = "menu")
public class MenuEntity {
    @Id
    private String id;
    private String parentCode;
    private String code;
    private String nameZh;
    private String nameEn;
    private Integer level;
    private Integer seq;
}

/**
 * 
 */
package cn.himma.spring.boot.mongo.dao;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.transaction.annotation.Transactional;

import cn.himma.spring.boot.mongo.entity.MenuEntity;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年10月11日
 * @ClassName IMenuDao
 */
@Transactional
public interface IMenuDao extends MongoRepository<MenuEntity, String> {

}

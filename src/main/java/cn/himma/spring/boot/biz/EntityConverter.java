/**
 * 
 */
package cn.himma.spring.boot.biz;

import java.lang.reflect.Field;

import org.springframework.stereotype.Service;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年10月11日
 * @ClassName EntityConverter
 */
@Service
public class EntityConverter {
    public <T> T map(Object sourceObj, Class<T> targetClazz) {
        try {
            T t = targetClazz.newInstance();
            Field[] sourceFields = sourceObj.getClass().getDeclaredFields();
            Field[] targetFields = targetClazz.getDeclaredFields();
            for (Field sourceField : sourceFields) {
                for (Field targetField : targetFields) {
                    if (sourceField.getName().equals(targetField.getName())) {
                        boolean sourceAccess = sourceField.isAccessible();
                        boolean targetAccess = targetField.isAccessible();
                        sourceField.setAccessible(true);
                        targetField.setAccessible(true);
                        targetField.set(t, sourceField.get(sourceObj));
                        sourceField.setAccessible(sourceAccess);
                        targetField.setAccessible(targetAccess);
                    }
                }
            }
            return t;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}

/**
 * 
 */
package cn.himma.spring.boot.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年9月30日
 * @ClassName ResultVo
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ResultVo {
    private int code = 200;
    private boolean success = true;
    private String message;

    public ResultVo() {
    }

    public ResultVo(int code, boolean success, String message) {
        this.code = code;
        this.success = success;
        this.message = message;
    }
}

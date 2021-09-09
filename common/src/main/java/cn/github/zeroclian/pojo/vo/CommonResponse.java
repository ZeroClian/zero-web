package cn.github.zeroclian.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 统一响应对象定义
 *
 * @author qiyiguo
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResponse<T> implements Serializable {

    private String code;
    private String message;
    private T data;

    public CommonResponse(String code, String message) {

        this.code = code;
        this.message = message;
    }
}

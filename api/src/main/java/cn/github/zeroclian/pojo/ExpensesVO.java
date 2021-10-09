package cn.github.zeroclian.pojo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Desciption
 * @Author: qiyiguo
 * @Date: 2021-09-27 1:44 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExpensesVO implements Serializable {

    private Double expenses;

}

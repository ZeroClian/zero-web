package cn.github.zeroclian.financial.pojo.vo;

import lombok.*;

import javax.persistence.Column;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 收支记录查询接口VO
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListIncomeAndExpensesVO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 项目名
     */
    private String name;

    /**
     * 类别
     */
    private Integer categoryId;

    /**
     * 收支类型
     */
    private String type;

    /**
     * 金额
     */
    private String money;

    /**
     * 日期，DATE
     */
    private LocalDate date;
}

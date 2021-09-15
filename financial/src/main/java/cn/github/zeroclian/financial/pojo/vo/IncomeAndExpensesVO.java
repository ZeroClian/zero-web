package cn.github.zeroclian.financial.pojo.vo;

import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 收支记录基本VO, 用于回显
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeAndExpensesVO {

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
    private Date date;

}

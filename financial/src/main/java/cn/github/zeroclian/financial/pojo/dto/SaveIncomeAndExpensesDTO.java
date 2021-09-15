package cn.github.zeroclian.financial.pojo.dto;

import cn.github.zeroclian.enumeration.FinancialTypeEnum;
import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 收支记录参数类
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaveIncomeAndExpensesDTO {

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
    private FinancialTypeEnum type;

    /**
     * 金额
     */
    private Double money;

    /**
     * 日期，DATE
     */
    private Date date;

}

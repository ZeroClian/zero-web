package cn.github.zeroclian.financial.pojo.vo;

import lombok.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 财务类别查询接口VO
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListCategoryVO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 类型名
     */
    private String name;

    /**
     * 所属分类
     */
    private Integer parentId;

    /**
     * 级别
     */
    private Integer level;


}

package cn.github.zeroclian.financial.pojo.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 财务类别实体类
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCategoryDTO {

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

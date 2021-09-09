package cn.github.zeroclian.blog.pojo.dto;

import lombok.*;

import javax.validation.constraints.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 博客实体类
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateBlogDTO {

    /**
     * 博客名
     */
    private String blogName;
    /**
     * 博客内容
     */
    private String content;

}

package cn.github.zeroclian.blog.pojo.vo;

import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 博客查询接口VO
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ListBlogVO {

    /**
     * ID
     */
    private Integer blogId;

    /**
     * 博客名
     */
    private String blogName;

    /**
     * 博客内容
     */
    private String content;


}

package cn.github.zeroclian.blog.pojo.vo;

import lombok.*;

import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 博客Get接口VO
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class GetBlogVO {

    /**
     * ID
     */
    private Integer id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 博客名
     */
    private String name;

    /**
     * 博客内容
     */
    private String content;


}

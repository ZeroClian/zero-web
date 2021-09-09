package cn.github.zeroclian.blog.pojo.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.github.zeroclian.jpa.JPAManageable;

/**
 * 博客实体类
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "blog")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Blog extends JPAManageable {

    /**
     * 博客名, VARCHAR
     */
    @Column(name = "name")
    private String name;

    /**
     * 博客内容, TEXT
     */
    @Column(name = "content")
    private String content;


}

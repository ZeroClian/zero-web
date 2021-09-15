package cn.github.zeroclian.financial.pojo.entity;

import lombok.*;
import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import cn.github.zeroclian.jpa.JPAManageable;

/**
 * 财务类别实体类
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "f_category" )
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category extends JPAManageable {

	/**
	 * 类型名, VARCHAR
	 */
    @Column(name = "name")
	private String name;

	/**
	 * 所属分类, INT
	 */
    @Column(name = "parent_id")
	private Integer parentId;

	/**
	 * 级别, INT
	 */
    @Column(name = "level")
	private Integer level;


}

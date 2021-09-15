package cn.github.zeroclian.financial.pojo.entity;

import cn.github.zeroclian.enumeration.FinancialTypeEnum;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import cn.github.zeroclian.jpa.JPAManageable;

/**
 * 收支记录实体类
 *
 * @author by code generator
 * @version 1.0.0
 */
@Data
@Entity
@Table(name = "f_income_and_expenses")
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class IncomeAndExpenses extends JPAManageable {

	/**
	 * 项目名, VARCHAR
	 */
	@Column(name = "name")
	private String name;

	/**
	 * 类别, INT
	 */
	@Column(name = "category_id")
	private Integer categoryId;

	/**
	 * 收支类型, VARCHAR
	 */
	@Column(name = "type")
	@Enumerated(EnumType.STRING)
	private FinancialTypeEnum type;

	/**
	 * 金额, VARCHAR
	 */
	@Column(name = "money")
	private Double money;

	/**
	 * 日期，DATE
	 */
	@Column(name = "date")
	private LocalDate date;
}

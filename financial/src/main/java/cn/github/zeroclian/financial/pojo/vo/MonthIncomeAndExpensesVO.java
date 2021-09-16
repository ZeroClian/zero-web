package cn.github.zeroclian.financial.pojo.vo;

import lombok.Data;

import java.time.LocalDate;
import java.util.Map;

/**
 * @Desciption 月收支统计
 * @Author: qiyiguo
 * @Date: 2021-09-16 5:33 下午
 */
@Data
public class MonthIncomeAndExpensesVO {

    /**
     * 月总收入
     */
    private Double monthIncome;

    /**
     * 月总支出
     */
    private Double monthExpenses;

    /**
     * 月数据
     */
    private Map<LocalDate, DayIncomeAndExpenses> data;
}

package cn.github.zeroclian.financial.pojo.vo;

import lombok.Data;

import java.util.Map;

/**
 * @Desciption 一周收支详情
 * @Author: qiyiguo
 * @Date: 2021-09-16 4:07 下午
 */
@Data
public class WeekIncomeAndExpensesVO {

    /**
     * 一周总收入
     */
    private Double weekIncome;

    /**
     * 一周总支出
     */
    private Double weekExpenses;

    /**
     * 周一到周日数据
     */
    private Map<String, DayIncomeAndExpenses> data;
}

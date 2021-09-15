package cn.github.zeroclian.financial.pojo.vo;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @Desciption 某日收支汇总
 * @Author: qiyiguo
 * @Date: 2021-09-15 4:06 下午
 */
@Data
@Builder
public class DayIncomeAndExpenses {

    /**
     * 收入
     */
    private Double income;

    /**
     * 支出
     */
    private Double expenses;

    /**
     * 详情
     */
    private List<ListIncomeAndExpensesVO> dayData;
}

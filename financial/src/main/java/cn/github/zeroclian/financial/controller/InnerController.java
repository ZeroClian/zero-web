package cn.github.zeroclian.financial.controller;

import cn.github.zeroclian.annotation.IgnoreResponseAdvice;
import cn.github.zeroclian.financial.management.IncomeAndExpensesManager;
import cn.github.zeroclian.financial.pojo.vo.MonthIncomeAndExpensesVO;
import cn.github.zeroclian.pojo.ExpensesVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

/**
 * @Desciption
 * @Author: qiyiguo
 * @Date: 2021-09-27 9:46 上午
 */
@RestController
@RequestMapping("/inner")
@IgnoreResponseAdvice
@RequiredArgsConstructor
public class InnerController {

    private final IncomeAndExpensesManager incomeAndExpensesManager;

    @GetMapping("/month/expenses/{date}")
    public ExpensesVO getExpensesMonth(@PathVariable("date") LocalDate date) {
        MonthIncomeAndExpensesVO vo = incomeAndExpensesManager.findMonthIncomeAndExpenses(Optional.ofNullable(date).orElse(LocalDate.now()));
        ExpensesVO expensesVO = ExpensesVO.builder().expenses(vo.getMonthExpenses()).build();
        System.out.println(expensesVO.getExpenses());
        return expensesVO;
    }
}

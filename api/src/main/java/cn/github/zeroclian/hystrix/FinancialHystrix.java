package cn.github.zeroclian.hystrix;

import cn.github.zeroclian.pojo.ExpensesVO;
import cn.github.zeroclian.service.FinancialService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: qiyiguo
 * @Date: 2021-10-09 3:36 下午
 */
@Slf4j
@Component
public class FinancialHystrix implements FinancialService {
    @Override
    public ExpensesVO getExpensesMonth(LocalDate date) {
        log.error("getExpensesMonth ：方法调用失败，熔断时间：{}", LocalDateTime.now());
        return ExpensesVO.builder().expenses(-1d).build();
    }
}

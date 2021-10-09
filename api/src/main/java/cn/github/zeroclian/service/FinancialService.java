package cn.github.zeroclian.service;

import cn.github.zeroclian.config.FeignConfig;
import cn.github.zeroclian.hystrix.FinancialHystrix;
import cn.github.zeroclian.pojo.ExpensesVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

/**
 * @Desciption
 * @Author: qiyiguo
 * @Date: 2021-09-27 9:29 上午
 */
@FeignClient(name = "zero-financial", path = "/inner", configuration = FeignConfig.class, fallback = FinancialHystrix.class)
public interface FinancialService {

    @GetMapping("/month/expenses/{date}")
    ExpensesVO getExpensesMonth(@RequestParam("date") LocalDate date);
}

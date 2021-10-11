package cn.github.zeroclian.schedule;

import cn.github.zeroclian.config.GlobalConfig;
import cn.github.zeroclian.financial.management.IncomeAndExpensesManager;
import cn.github.zeroclian.financial.pojo.vo.MonthIncomeAndExpensesVO;
import com.xxl.job.core.context.XxlJobHelper;
import com.xxl.job.core.handler.annotation.XxlJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * @Author: qiyiguo
 * @Date: 2021-10-11 2:58 下午
 */
@Component
@Slf4j
public class DemoJob {
    private final IncomeAndExpensesManager incomeAndExpensesManager;
    private final GlobalConfig globalConfig;

    public DemoJob(IncomeAndExpensesManager incomeAndExpensesManager, GlobalConfig globalConfig) {
        this.incomeAndExpensesManager = incomeAndExpensesManager;
        this.globalConfig = globalConfig;
    }

    @XxlJob(value = "demoExpenses")
    public void execute() throws Exception {
        String param = XxlJobHelper.getJobParam();
        log.info("开始执行调度任务:{}", param);
        try {
            MonthIncomeAndExpensesVO monthIncomeAndExpenses = incomeAndExpensesManager.findMonthIncomeAndExpenses(LocalDate.now().plusMonths(-1));
            log.info("{}执行完成：支出为{}", globalConfig.getAppName(), monthIncomeAndExpenses.getMonthExpenses());
        } catch (Exception e) {
            log.info("调度失败");
            e.printStackTrace();
        }
    }

}

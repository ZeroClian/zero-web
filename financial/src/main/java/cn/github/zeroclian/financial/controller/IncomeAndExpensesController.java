package cn.github.zeroclian.financial.controller;

import cn.github.zeroclian.financial.pojo.vo.DayIncomeAndExpenses;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import cn.github.zeroclian.financial.management.IncomeAndExpensesManager;
import cn.github.zeroclian.financial.pojo.dto.SaveIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.dto.ListIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.vo.IncomeAndExpensesVO;
import cn.github.zeroclian.financial.pojo.dto.UpdateIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.vo.ListIncomeAndExpensesVO;
import cn.github.zeroclian.financial.pojo.vo.GetIncomeAndExpensesVO;

import java.time.LocalDate;
import java.util.List;

/**
 * 收支记录接口
 *
 * @author by code generator
 * @version 1.0.0
 */
@RestController
@RequestMapping("/income_and_expenses")
public class IncomeAndExpensesController {

    private final IncomeAndExpensesManager incomeAndExpensesManager;

    public IncomeAndExpensesController(IncomeAndExpensesManager incomeAndExpensesManager) {
        this.incomeAndExpensesManager = incomeAndExpensesManager;
    }

    /**
     * 查询收支记录列表
     *
     * @param incomeAndExpensesDto 查询实体对象
     */
    @GetMapping
    public List<ListIncomeAndExpensesVO> listIncomeAndExpenses(ListIncomeAndExpensesDTO incomeAndExpensesDto) {
        return incomeAndExpensesManager.listIncomeAndExpenses(incomeAndExpensesDto);
    }

    /**
     * 新增收支记录
     *
     * @param saveIncomeAndExpensesDto 保存实体对象
     */
    @PostMapping
    public IncomeAndExpensesVO saveIncomeAndExpenses(@RequestBody SaveIncomeAndExpensesDTO saveIncomeAndExpensesDto) {
        return incomeAndExpensesManager.saveIncomeAndExpenses(saveIncomeAndExpensesDto);
    }

    /**
     * 更新收支记录
     *
     * @param updateIncomeAndExpensesDto 更新实体对象
     */
    @PutMapping("/{incomeAndExpensesId}")
    public IncomeAndExpensesVO updateIncomeAndExpenses(@RequestBody UpdateIncomeAndExpensesDTO updateIncomeAndExpensesDto, @PathVariable Integer incomeAndExpensesId) {
        return incomeAndExpensesManager.updateIncomeAndExpenses(updateIncomeAndExpensesDto, incomeAndExpensesId);
    }

    /**
     * 获取收支记录
     *
     * @param incomeAndExpensesId 收支记录 ID
     */
    @GetMapping("/{incomeAndExpensesId}")
    public GetIncomeAndExpensesVO getIncomeAndExpenses(@PathVariable Integer incomeAndExpensesId) {
        return incomeAndExpensesManager.getIncomeAndExpenses(incomeAndExpensesId);
    }

    /**
     * 删除收支记录
     *
     * @param incomeAndExpensesId 收支记录 ID
     */
    @DeleteMapping("/{incomeAndExpensesId}")
    public void deleteByIncomeAndExpensesId(@PathVariable Integer incomeAndExpensesId) {
        incomeAndExpensesManager.deleteByIncomeAndExpensesId(incomeAndExpensesId);
    }

    /**
     * 今日收支
     *
     * @param date 查询日期
     */
    @GetMapping("/today")
    public DayIncomeAndExpenses findIncomeAndExpensesByDate(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return incomeAndExpensesManager.findIncomeAndExpensesByDate(date);
    }


}

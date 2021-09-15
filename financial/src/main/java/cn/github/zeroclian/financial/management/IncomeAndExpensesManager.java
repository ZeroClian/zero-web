package cn.github.zeroclian.financial.management;

import javax.validation.Valid;

import cn.github.zeroclian.financial.pojo.vo.DayIncomeAndExpenses;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

import cn.github.zeroclian.financial.pojo.entity.IncomeAndExpenses;
import cn.github.zeroclian.financial.pojo.dto.SaveIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.dto.ListIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.vo.IncomeAndExpensesVO;
import cn.github.zeroclian.financial.pojo.dto.UpdateIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.vo.ListIncomeAndExpensesVO;
import cn.github.zeroclian.financial.pojo.vo.GetIncomeAndExpensesVO;
import cn.github.zeroclian.jpa.CrudManager;

import java.time.LocalDate;
import java.util.List;

/**
 * 收支记录服务层接口
 *
 * @author by code generator
 * @version 1.0.0
 */
@Validated
public interface IncomeAndExpensesManager extends CrudManager<IncomeAndExpenses, Integer> {

    /**
     * 查询收支记录列表
     *
     * @param incomeAndExpensesDto 查询实体对象
     */
    List<ListIncomeAndExpensesVO> listIncomeAndExpenses(ListIncomeAndExpensesDTO incomeAndExpensesDto);

    /**
     * 保存收支记录
     *
     * @param saveIncomeAndExpensesDto 保存实体对象
     */
    IncomeAndExpensesVO saveIncomeAndExpenses(@Valid SaveIncomeAndExpensesDTO saveIncomeAndExpensesDto);

    /**
     * 更新收支记录
     *
     * @param updateIncomeAndExpensesDto 更新实体对象
     */
    IncomeAndExpensesVO updateIncomeAndExpenses(@Valid UpdateIncomeAndExpensesDTO updateIncomeAndExpensesDto, Integer incomeAndExpensesId);

    /**
     * 根据收支记录 ID 查找 收支记录
     *
     * @param incomeAndExpensesId 收支记录 ID
     */
    GetIncomeAndExpensesVO getIncomeAndExpenses(@NotNull(message = "ID不能为空") Integer incomeAndExpensesId);

    /**
     * 根据收支记录 ID 删除 收支记录
     *
     * @param incomeAndExpensesId 收支记录 ID
     */
    void deleteByIncomeAndExpensesId(@NotNull(message = "ID不能为空") Integer incomeAndExpensesId);

    /**
     * 根据日期 date 查找收支
     *
     * @param date 日期
     */
    DayIncomeAndExpenses findIncomeAndExpensesByDate(@NotNull(message = "日期不能为空") LocalDate date);
}

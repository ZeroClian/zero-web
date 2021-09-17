package cn.github.zeroclian.financial.management.impl;

import cn.github.zeroclian.enumeration.CommonResultStatus;
import cn.github.zeroclian.enumeration.FinancialTypeEnum;
import cn.github.zeroclian.financial.management.IncomeAndExpensesManager;
import cn.github.zeroclian.financial.pojo.dto.ListIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.dto.SaveIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.dto.UpdateIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.entity.Category;
import cn.github.zeroclian.financial.pojo.entity.IncomeAndExpenses;
import cn.github.zeroclian.financial.pojo.vo.*;
import cn.github.zeroclian.financial.repository.CategoryRepository;
import cn.github.zeroclian.financial.repository.IncomeAndExpensesRepository;
import cn.github.zeroclian.pojo.vo.GlobalException;
import cn.github.zeroclian.util.DateUtils;
import cn.github.zeroclian.util.ReflectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 收支记录服务层实现
 *
 * @author by code generator
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JpaIncomeAndExpensesManager implements IncomeAndExpensesManager {


    private final IncomeAndExpensesRepository incomeAndExpensesRepository;
    private final CategoryRepository categoryRepository;

    @Override
    public CrudRepository<IncomeAndExpenses, Integer> getRepository() {
        return this.incomeAndExpensesRepository;
    }

    @Override
    public List<ListIncomeAndExpensesVO> listIncomeAndExpenses(ListIncomeAndExpensesDTO incomeAndExpensesDto) {
        List<IncomeAndExpenses> all = incomeAndExpensesRepository.findAll();
        return all.stream().map(a -> ReflectUtils.convert(a, ListIncomeAndExpensesVO.class))
                .sorted(Comparator.comparing(ListIncomeAndExpensesVO::getId).reversed()).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeAndExpensesVO saveIncomeAndExpenses(SaveIncomeAndExpensesDTO saveIncomeAndExpensesDto) {
        if (saveIncomeAndExpensesDto.getCategoryId() == null) {
            throw new GlobalException(CommonResultStatus.Data_IS_NOT_EXPECTED, "分类ID不能为null");
        }
        IncomeAndExpenses incomeAndExpenses = ReflectUtils.convert(saveIncomeAndExpensesDto, IncomeAndExpenses.class);
        if (incomeAndExpenses.getName() == null || "".equals(incomeAndExpenses.getName())) {
            incomeAndExpenses.setName(getCategoryName(incomeAndExpenses.getCategoryId()));
        }
        IncomeAndExpenses save = incomeAndExpensesRepository.save(incomeAndExpenses);
        return ReflectUtils.convert(save, IncomeAndExpensesVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeAndExpensesVO updateIncomeAndExpenses(UpdateIncomeAndExpensesDTO updateIncomeAndExpensesDto, Integer incomeAndExpensesId) {
        IncomeAndExpenses incomeAndExpenses = incomeAndExpensesRepository.findById(incomeAndExpensesId).orElseThrow(() -> new GlobalException(CommonResultStatus.NO_RECORDS_FOUND));
        if (updateIncomeAndExpensesDto.getCategoryId() == null) {
            throw new GlobalException(CommonResultStatus.Data_IS_NOT_EXPECTED, "分类ID不能为null");
        }
        IncomeAndExpenses save = ReflectUtils.convert(updateIncomeAndExpensesDto, IncomeAndExpenses.class);
        if (save.getName() == null || "".equals(save.getName())) {
            save.setName(getCategoryName(updateIncomeAndExpensesDto.getCategoryId()));
        }
        save.setId(incomeAndExpenses.getId());
        IncomeAndExpenses result = incomeAndExpensesRepository.save(save);
        return ReflectUtils.convert(result, IncomeAndExpensesVO.class);
    }

    @Override
    public GetIncomeAndExpensesVO getIncomeAndExpenses(Integer incomeAndExpensesId) {
        IncomeAndExpenses incomeAndExpenses = incomeAndExpensesRepository.findById(incomeAndExpensesId).orElseThrow(() -> new GlobalException(CommonResultStatus.NO_RECORDS_FOUND));
        return ReflectUtils.convert(incomeAndExpenses, GetIncomeAndExpensesVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByIncomeAndExpensesId(Integer incomeAndExpensesId) {
        incomeAndExpensesRepository.deleteById(incomeAndExpensesId);
    }

    @Override
    public DayIncomeAndExpenses findIncomeAndExpensesByDate(LocalDate date) {
        List<IncomeAndExpenses> incomeAndExpensesList = incomeAndExpensesRepository.findAllByDate(date);
        double income = incomeAndExpensesList.stream().filter(i -> FinancialTypeEnum.IN.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum();
        double expenses = incomeAndExpensesList.stream().filter(i -> FinancialTypeEnum.OUT.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum();
        return DayIncomeAndExpenses.builder()
                .income(income).expenses(expenses)
                .dayData(incomeAndExpensesList.stream().map(i -> ReflectUtils.convert(i, ListIncomeAndExpensesVO.class)).collect(Collectors.toList()))
                .build();
    }

    @Override
    public WeekIncomeAndExpensesVO findWeekIncomeAndExpenses(LocalDate date) {
        LocalDate weekStart = DateUtils.getWeekStart(date);
        LocalDate weekEnd = DateUtils.getWeekEnd(date);
        List<IncomeAndExpenses> incomeAndExpensesList = incomeAndExpensesRepository.findByDateBetween(weekStart, weekEnd);
        WeekIncomeAndExpensesVO week = new WeekIncomeAndExpensesVO();
        week.setWeekIncome(incomeAndExpensesList.stream().filter(i -> FinancialTypeEnum.IN.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum());
        week.setWeekExpenses(incomeAndExpensesList.stream().filter(i -> FinancialTypeEnum.OUT.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum());
        Map<String, DayIncomeAndExpenses> data = new HashMap<>();
        List<LocalDate> dateList = DateUtils.getBetweenLocalDate(weekStart, weekEnd);
        dateList.stream().forEach(d -> {
            List<IncomeAndExpenses> dayData = incomeAndExpensesList.stream().filter(i -> i.getDate().equals(d)).collect(Collectors.toList());
            String weekNum = DateUtils.dateToWeek(DateUtils.localDate2Date(d));
            data.put(weekNum, DayIncomeAndExpenses.builder()
                    .income(dayData.stream().filter(i -> FinancialTypeEnum.IN.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum())
                    .expenses(dayData.stream().filter(i -> FinancialTypeEnum.OUT.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum())
                    .dayData(dayData.stream().map(i -> ReflectUtils.convert(i, ListIncomeAndExpensesVO.class)).collect(Collectors.toList()))
                    .build());
        });
        week.setData(data);
        return week;
    }

    @Override
    public MonthIncomeAndExpensesVO findMonthIncomeAndExpenses(LocalDate date) {
        LocalDate monthStart = DateUtils.getMonthStart(date);
        LocalDate monthEnd = DateUtils.getMonthEnd(date);
        List<IncomeAndExpenses> incomeAndExpensesList = incomeAndExpensesRepository.findByDateBetween(monthStart, monthEnd);
        MonthIncomeAndExpensesVO month = new MonthIncomeAndExpensesVO();
        month.setMonthIncome(incomeAndExpensesList.stream().filter(i -> FinancialTypeEnum.IN.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum());
        month.setMonthExpenses(incomeAndExpensesList.stream().filter(i -> FinancialTypeEnum.OUT.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum());
        Map<LocalDate, DayIncomeAndExpenses> data = new HashMap<>();
        List<LocalDate> dateList = DateUtils.getBetweenLocalDate(monthStart, monthEnd);
        dateList.stream().forEach(d -> {
            List<IncomeAndExpenses> dayData = incomeAndExpensesList.stream().filter(i -> i.getDate().equals(d)).collect(Collectors.toList());
            data.put(d, DayIncomeAndExpenses.builder()
                    .income(dayData.stream().filter(i -> FinancialTypeEnum.IN.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum())
                    .expenses(dayData.stream().filter(i -> FinancialTypeEnum.OUT.equals(i.getType())).mapToDouble(IncomeAndExpenses::getMoney).sum())
                    .dayData(dayData.stream().map(i -> ReflectUtils.convert(i, ListIncomeAndExpensesVO.class)).collect(Collectors.toList()))
                    .build());
        });
        month.setData(data);
        return month;
    }

    public String getCategoryName(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new GlobalException(CommonResultStatus.NO_RECORDS_FOUND));
        return category.getName();
    }

}

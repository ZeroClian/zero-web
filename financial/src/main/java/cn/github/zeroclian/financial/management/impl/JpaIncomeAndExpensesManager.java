package cn.github.zeroclian.financial.management.impl;

import cn.github.zeroclian.enumeration.CommonResultStatus;
import cn.github.zeroclian.enumeration.FinancialTypeEnum;
import cn.github.zeroclian.financial.pojo.vo.DayIncomeAndExpenses;
import cn.github.zeroclian.pojo.vo.GlobalException;
import cn.github.zeroclian.util.ReflectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import cn.github.zeroclian.financial.pojo.entity.IncomeAndExpenses;
import cn.github.zeroclian.financial.management.IncomeAndExpensesManager;
import cn.github.zeroclian.financial.repository.IncomeAndExpensesRepository;
import cn.github.zeroclian.financial.pojo.dto.SaveIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.dto.UpdateIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.dto.ListIncomeAndExpensesDTO;
import cn.github.zeroclian.financial.pojo.vo.ListIncomeAndExpensesVO;
import cn.github.zeroclian.financial.pojo.vo.IncomeAndExpensesVO;
import cn.github.zeroclian.financial.pojo.vo.GetIncomeAndExpensesVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
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
        IncomeAndExpenses incomeAndExpenses = ReflectUtils.convert(saveIncomeAndExpensesDto, IncomeAndExpenses.class);
        IncomeAndExpenses save = incomeAndExpensesRepository.save(incomeAndExpenses);
        return ReflectUtils.convert(save, IncomeAndExpensesVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public IncomeAndExpensesVO updateIncomeAndExpenses(UpdateIncomeAndExpensesDTO updateIncomeAndExpensesDto, Integer incomeAndExpensesId) {
        IncomeAndExpenses incomeAndExpenses = incomeAndExpensesRepository.findById(incomeAndExpensesId).orElseThrow(() -> new GlobalException(CommonResultStatus.NO_RECORDS_FOUND));
        IncomeAndExpenses save = ReflectUtils.convert(updateIncomeAndExpensesDto, IncomeAndExpenses.class);
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

}

package cn.github.zeroclian.financial.repository;

import cn.github.zeroclian.financial.pojo.entity.IncomeAndExpenses;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

/**
 * 收支记录 持久化层
 *
 * @author by code generator
 * @version 1.0.0
 */
public interface IncomeAndExpensesRepository extends JpaRepository<IncomeAndExpenses, Integer> {

    List<IncomeAndExpenses> findAllByDate(LocalDate date);

    List<IncomeAndExpenses> findByDateBetween(LocalDate startDate, LocalDate endDate);
}

package cn.github.zeroclian.financial.repository;


import cn.github.zeroclian.financial.pojo.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 财务类别 持久化层
 *
 * @author by code generator
 * @version 1.0.0
 */
public interface CategoryRepository extends JpaRepository<Category, Integer> {

    Category findByNameAndLevel(String name, Integer level);
}

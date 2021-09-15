package cn.github.zeroclian.financial.management;

import javax.validation.Valid;

import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.*;

import cn.github.zeroclian.financial.pojo.entity.Category;
import cn.github.zeroclian.financial.pojo.dto.SaveCategoryDTO;
import cn.github.zeroclian.financial.pojo.dto.ListCategoryDTO;
import cn.github.zeroclian.financial.pojo.vo.CategoryVO;
import cn.github.zeroclian.financial.pojo.dto.UpdateCategoryDTO;
import cn.github.zeroclian.financial.pojo.vo.ListCategoryVO;
import cn.github.zeroclian.financial.pojo.vo.GetCategoryVO;
import cn.github.zeroclian.jpa.CrudManager;

import java.util.List;

/**
 * 财务类别服务层接口
 *
 * @author by code generator
 * @version 1.0.0
 */
@Validated
public interface CategoryManager extends CrudManager<Category, Integer> {

    /**
     * 查询财务类别列表
     *
     * @param categoryDto 查询实体对象
     */
    List<ListCategoryVO> listCategory(ListCategoryDTO categoryDto);

    /**
     * 保存财务类别
     *
     * @param saveCategoryDto 保存实体对象
     */
    CategoryVO saveCategory(@Valid SaveCategoryDTO saveCategoryDto);

    /**
     * 更新财务类别
     *
     * @param updateCategoryDto 更新实体对象
     */
    CategoryVO updateCategory(@Valid UpdateCategoryDTO updateCategoryDto, Integer categoryId);

    /**
     * 根据财务类别 ID 查找 财务类别
     *
     * @param categoryId 财务类别 ID
     */
    GetCategoryVO getCategory(@NotNull(message = "ID不能为空") Integer categoryId);

    /**
     * 根据财务类别 ID 删除 财务类别
     *
     * @param categoryId 财务类别 ID
     */
    void deleteByCategoryId(@NotNull(message = "ID不能为空") Integer categoryId);

}

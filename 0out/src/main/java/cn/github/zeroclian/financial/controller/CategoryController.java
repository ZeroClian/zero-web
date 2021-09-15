package cn.github.zeroclian.financial.controller;

import org.springframework.web.bind.annotation.*;
import cn.github.zeroclian.financial.management.CategoryManager;
import cn.github.zeroclian.financial.pojo.dto.SaveCategoryDTO;
import cn.github.zeroclian.financial.pojo.dto.ListCategoryDTO;
import cn.github.zeroclian.financial.pojo.vo.CategoryVO;
import cn.github.zeroclian.financial.pojo.dto.UpdateCategoryDTO;
import cn.github.zeroclian.financial.pojo.vo.ListCategoryVO;
import cn.github.zeroclian.financial.pojo.vo.GetCategoryVO;
import java.util.List;

/**
 * 财务类别接口
 * @author by code generator
 * @version 1.0.0
 */
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryManager categoryManager;

    public CategoryController(CategoryManager categoryManager) {
        this.categoryManager = categoryManager;
    }

    /**
     * 查询财务类别列表
     * @TODO
     * @param categoryDto 查询实体对象
     */
    @GetMapping
    public List<ListCategoryVO> listCategory(ListCategoryDTO categoryDto){
        return categoryManager.listCategory(categoryDto);
    }

    /**
     * 新增财务类别
     * @TODO
     * @param saveCategoryDto 保存实体对象
     */
    @PostMapping
    public CategoryVO saveCategory(@RequestBody SaveCategoryDTO saveCategoryDto){
        return categoryManager.saveCategory(saveCategoryDto);
    }

    /**
     * 更新财务类别
     * @TODO
     * @param updateCategoryDto 更新实体对象
     */
    @PutMapping("/{categoryId}")
    public CategoryVO updateCategory(@RequestBody UpdateCategoryDTO updateCategoryDto,@PathVariable Integer categoryId){
        return categoryManager.updateCategory(updateCategoryDto,categoryId);
    }

    /**
     * 获取财务类别
     * @TODO
     * @param categoryId   财务类别 ID
     */
    @GetMapping("/{categoryId}")
    public GetCategoryVO getCategory(@PathVariable Integer categoryId){
        return categoryManager.getCategory(categoryId);
    }

    /**
     * 删除财务类别
     * @TODO
     * @param categoryId   财务类别 ID
     */
    @DeleteMapping("/{categoryId}")
    public void deleteByCategoryId(@PathVariable Integer categoryId){
        categoryManager.deleteByCategoryId(categoryId);
    }

}

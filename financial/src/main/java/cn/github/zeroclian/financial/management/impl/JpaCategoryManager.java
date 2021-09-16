package cn.github.zeroclian.financial.management.impl;

import cn.github.zeroclian.enumeration.CommonResultStatus;
import cn.github.zeroclian.financial.management.CategoryManager;
import cn.github.zeroclian.financial.pojo.dto.ListCategoryDTO;
import cn.github.zeroclian.financial.pojo.dto.SaveCategoryDTO;
import cn.github.zeroclian.financial.pojo.dto.UpdateCategoryDTO;
import cn.github.zeroclian.financial.pojo.entity.Category;
import cn.github.zeroclian.financial.pojo.vo.CategoryVO;
import cn.github.zeroclian.financial.pojo.vo.GetCategoryVO;
import cn.github.zeroclian.financial.pojo.vo.ListCategoryVO;
import cn.github.zeroclian.financial.repository.CategoryRepository;
import cn.github.zeroclian.pojo.vo.GlobalException;
import cn.github.zeroclian.util.ReflectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 财务类别服务层实现
 *
 * @author by code generator
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JpaCategoryManager implements CategoryManager {


    private final CategoryRepository categoryRepository;

    @Override
    public CrudRepository<Category, Integer> getRepository() {
        return this.categoryRepository;
    }

    @Override
    public List<ListCategoryVO> listCategory(ListCategoryDTO categoryDto) {
        List<Category> all = categoryRepository.findAll();
        return all.stream().sorted(Comparator.comparing(Category::getLevel).thenComparing(Category::getId))
                .map(a -> ReflectUtils.convert(a, ListCategoryVO.class)).collect(Collectors.toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryVO saveCategory(SaveCategoryDTO saveCategoryDto) {
        Category category = categoryRepository.findByNameAndLevel(saveCategoryDto.getName(), saveCategoryDto.getLevel());
        if (category != null) {
            throw new GlobalException(CommonResultStatus.Data_IS_NOT_EXPECTED, "该类别已存在！");
        }
        Category save = ReflectUtils.convert(saveCategoryDto, Category.class);
        Category result = categoryRepository.save(save);
        return ReflectUtils.convert(result, CategoryVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryVO updateCategory(UpdateCategoryDTO updateCategoryDto, Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new GlobalException(CommonResultStatus.NO_RECORDS_FOUND));
        Category save = ReflectUtils.convert(updateCategoryDto, Category.class);
        save.setId(category.getId());
        Category result = categoryRepository.save(save);
        return ReflectUtils.convert(result, CategoryVO.class);
    }

    @Override
    public GetCategoryVO getCategory(Integer categoryId) {
        Category category = categoryRepository.findById(categoryId).orElseThrow(() -> new GlobalException(CommonResultStatus.NO_RECORDS_FOUND));
        return ReflectUtils.convert(category, GetCategoryVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByCategoryId(Integer categoryId) {
        categoryRepository.deleteById(categoryId);
    }

}

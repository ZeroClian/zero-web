package cn.github.zeroclian.financial.management.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import cn.github.zeroclian.financial.pojo.entity.Category;
import cn.github.zeroclian.financial.management.CategoryManager;
import cn.github.zeroclian.financial.repository.CategoryRepository;
import cn.github.zeroclian.financial.pojo.dto.SaveCategoryDTO;
import cn.github.zeroclian.financial.pojo.dto.UpdateCategoryDTO;
import cn.github.zeroclian.financial.pojo.dto.ListCategoryDTO;
import cn.github.zeroclian.financial.pojo.vo.ListCategoryVO;
import cn.github.zeroclian.financial.pojo.vo.CategoryVO;
import cn.github.zeroclian.financial.pojo.vo.GetCategoryVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 财务类别服务层实现
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
    public List<ListCategoryVO> listCategory(ListCategoryDTO categoryDto){
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryVO saveCategory(SaveCategoryDTO saveCategoryDto){
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CategoryVO updateCategory(UpdateCategoryDTO updateCategoryDto,Integer categoryId){
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    public GetCategoryVO getCategory(Integer categoryId){
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    public void deleteByCategoryId(Integer categoryId){
        throw new UnsupportedOperationException("未实现");
    }

}

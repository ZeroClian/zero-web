package cn.github.zeroclian.blog.management;

import cn.github.zeroclian.blog.pojo.dto.ListBlogDTO;
import cn.github.zeroclian.blog.pojo.dto.SaveBlogDTO;
import cn.github.zeroclian.blog.pojo.dto.UpdateBlogDTO;
import cn.github.zeroclian.blog.pojo.entity.Blog;
import cn.github.zeroclian.blog.pojo.vo.BlogVO;
import cn.github.zeroclian.blog.pojo.vo.GetBlogVO;
import cn.github.zeroclian.blog.pojo.vo.ListBlogVO;
import cn.github.zeroclian.jpa.CrudManager;
import cn.github.zeroclian.pojo.ExpensesVO;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

/**
 * 博客服务层接口
 *
 * @author by code generator
 * @version 1.0.0
 */
@Validated
public interface BlogManager extends CrudManager<Blog, Integer> {

    /**
     * 查询博客列表
     *
     * @param blogDto 查询实体对象
     */
    List<ListBlogVO> listBlog(ListBlogDTO blogDto);

    /**
     * 保存博客
     *
     * @param saveBlogDto 保存实体对象
     */
    BlogVO saveBlog(@Valid SaveBlogDTO saveBlogDto);

    /**
     * 更新博客
     *
     * @param updateBlogDto 更新实体对象
     */
    BlogVO updateBlog(@Valid UpdateBlogDTO updateBlogDto, Integer blogId);

    /**
     * 根据博客 ID 查找 博客
     *
     * @param blogId 博客 ID
     */
    GetBlogVO getBlog(@NotNull(message = "ID不能为空") Integer blogId);

    /**
     * 根据博客 ID 删除 博客
     *
     * @param blogId 博客 ID
     */
    void deleteByBlogId(@NotNull(message = "ID不能为空") Integer blogId);

    /**
     * 获取月支出
     *
     * @param date 日期
     * @return
     */
    ExpensesVO getExpenses(LocalDate date);
}

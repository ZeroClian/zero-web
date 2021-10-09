package cn.github.zeroclian.blog.controller;

import cn.github.zeroclian.blog.management.BlogManager;
import cn.github.zeroclian.blog.pojo.dto.ListBlogDTO;
import cn.github.zeroclian.blog.pojo.dto.SaveBlogDTO;
import cn.github.zeroclian.blog.pojo.dto.UpdateBlogDTO;
import cn.github.zeroclian.blog.pojo.vo.BlogVO;
import cn.github.zeroclian.blog.pojo.vo.GetBlogVO;
import cn.github.zeroclian.blog.pojo.vo.ListBlogVO;
import cn.github.zeroclian.pojo.ExpensesVO;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

/**
 * 博客接口
 *
 * @author by code generator
 * @version 1.0.0
 */
@RestController
@RequestMapping("/blog")
public class BlogController {

    private final BlogManager blogManager;

    public BlogController(BlogManager blogManager) {
        this.blogManager = blogManager;
    }

    /**
     * 查询博客列表
     *
     * @param blogDto 查询实体对象
     * @TODO
     */
    @GetMapping
    public List<ListBlogVO> listBlog(ListBlogDTO blogDto) {
        return blogManager.listBlog(blogDto);
    }

    /**
     * 新增博客
     *
     * @param saveBlogDto 保存实体对象
     * @TODO
     */
    @PostMapping
    public BlogVO saveBlog(@RequestBody SaveBlogDTO saveBlogDto) {
        return blogManager.saveBlog(saveBlogDto);
    }

    /**
     * 更新博客
     *
     * @param updateBlogDto 更新实体对象
     * @TODO
     */
    @PutMapping("/{blogId}")
    public BlogVO updateBlog(@RequestBody UpdateBlogDTO updateBlogDto, @PathVariable Integer blogId) {
        return blogManager.updateBlog(updateBlogDto, blogId);
    }

    /**
     * 获取博客
     *
     * @param blogId 博客 ID
     * @TODO
     */
    @GetMapping("/{blogId}")
    public GetBlogVO getBlog(@PathVariable Integer blogId) {
        return blogManager.getBlog(blogId);
    }

    /**
     * 删除博客
     *
     * @param blogId 博客 ID
     */
    @DeleteMapping("/{blogId}")
    public void deleteByBlogId(@PathVariable Integer blogId) {
        blogManager.deleteByBlogId(blogId);
    }

    /**
     * 获取月支出
     */
    @GetMapping("/expenses")
    public ExpensesVO getExpenses(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return blogManager.getExpenses(date);
    }
}

package cn.github.zeroclian.blog.management.impl;

import cn.github.zeroclian.blog.pojo.entity.Blog;
import cn.github.zeroclian.enumeration.CommonResultStatus;
import cn.github.zeroclian.pojo.vo.GlobalException;
import cn.github.zeroclian.util.ReflectUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import cn.github.zeroclian.blog.management.BlogManager;
import cn.github.zeroclian.blog.repository.BlogRepository;
import cn.github.zeroclian.blog.pojo.dto.SaveBlogDTO;
import cn.github.zeroclian.blog.pojo.dto.UpdateBlogDTO;
import cn.github.zeroclian.blog.pojo.dto.ListBlogDTO;
import cn.github.zeroclian.blog.pojo.vo.ListBlogVO;
import cn.github.zeroclian.blog.pojo.vo.BlogVO;
import cn.github.zeroclian.blog.pojo.vo.GetBlogVO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

/**
 * 博客服务层实现
 *
 * @author by code generator
 * @version 1.0.0
 */
@Slf4j
@Service
@RequiredArgsConstructor
public class JpaBlogManager implements BlogManager {


    private final BlogRepository blogRepository;

    @Override
    public CrudRepository<Blog, Integer> getRepository() {
        return this.blogRepository;
    }

    @Override
    public List<ListBlogVO> listBlog(ListBlogDTO blogDto) {
        throw new GlobalException(CommonResultStatus.ERROR);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BlogVO saveBlog(SaveBlogDTO saveBlogDto) {
        int i = 1 / 0;
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public BlogVO updateBlog(UpdateBlogDTO updateBlogDto, Integer blogId) {
        throw new UnsupportedOperationException("未实现");
    }

    @Override
    public GetBlogVO getBlog(Integer blogId) {
        Blog blog = blogRepository.findById(blogId).orElse(null);
        if (Objects.isNull(blog)) {
            log.info("blog is null");
        }
        assert blog != null;
        log.info("博客：{}", blog);
        log.info("createTime:{}", blog.getCreateTime());
        log.info("updateTime:{}", blog.getUpdateTime());
        return ReflectUtils.convert(blog, GetBlogVO.class);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void deleteByBlogId(Integer blogId) {
        blogRepository.deleteById(blogId);
    }

}

package cn.github.zeroclian.blog.repository;

import cn.github.zeroclian.blog.pojo.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 博客 持久化层
 *
 * @author by code generator
 * @version 1.0.0
 */
public interface BlogRepository extends JpaRepository<Blog, Integer> {


}

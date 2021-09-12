package cn.github.zeroclian;

import cn.github.zeroclian.pojo.bo.BlogBO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @Desciption
 * @Author: qiyiguo
 * @Date: 2021-09-12 11:33 上午
 */
@RestController
@RequestMapping("/config")
@RequiredArgsConstructor
@RefreshScope
public class TestController {

    private final RestTemplate restTemplate;

    @Value("${config}")
    private boolean config;

    @GetMapping("/echo/{str}")
    public BlogBO echo(@PathVariable String str) {
        BlogBO blogBO = restTemplate.getForObject("http://blog/blog/blog/echo/" + str, BlogBO.class);
        blogBO.setUseLocalCache(config);
        return blogBO;
    }

}

package cn.github.zeroclian.config;

import feign.Logger;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;


/**
 * @Desciption
 * @Author: qiyiguo
 * @Date: 2021-09-27 11:43 上午
 */
@Slf4j
@Configuration
public class FeignConfig implements RequestInterceptor {

    private static final String TOKEN = "token";

    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }

    @Override
    public void apply(RequestTemplate requestTemplate) {
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        if (requestAttributes != null) {
            ServletRequestAttributes attributes = (ServletRequestAttributes) requestAttributes;
            HttpServletRequest request = attributes.getRequest();
            //调用前带上token,如果没有，默认为admin
            if (request.getAttribute(TOKEN) == null) {
                requestTemplate.header(TOKEN, "admin");
                log.info(TOKEN + "{}", request.getHeader(TOKEN));
            } else {
                requestTemplate.header(TOKEN, request.getHeader("token"));
                log.info(TOKEN + "{}", request.getHeader(TOKEN));
            }
        }
    }
}


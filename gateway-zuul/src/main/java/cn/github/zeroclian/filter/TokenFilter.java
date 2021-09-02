package cn.github.zeroclian.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

/**
 * @Author: qiyiguo
 * @Date: 2021-08-31 2:58 下午
 */
@Slf4j
@Component
public class TokenFilter extends AbstractZuulFilter {
    @Override
    protected Object cRun() {
        HttpServletRequest request = context.getRequest();
        log.debug("{} request {}", request.getMethod(), request.getRequestURL().toString());
        String token = request.getHeader("token");
        if (Objects.isNull(token)) {
            log.error("error: token is empty!");
            return fail(401, "无效的token!");
        }
        //todo token校验
        return success();
    }

    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    @Override
    public int filterOrder() {
        return 1;
    }
}

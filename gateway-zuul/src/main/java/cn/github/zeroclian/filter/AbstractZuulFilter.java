package cn.github.zeroclian.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import java.util.Objects;

/**
 * @Author: qiyiguo
 * @Date: 2021-08-31 2:31 下午
 */
public abstract class AbstractZuulFilter extends ZuulFilter {

    private final static String NEXT = "next";
    /**
     * 用于在过滤器之间传递消息, 数据保存在每个请求的 ThreadLocal 中
     */
    RequestContext context;

    /**
     * 是否执行过滤器的run方法
     * true：执行；false：不执行
     *
     * @return
     */
    @Override
    public boolean shouldFilter() {
        RequestContext ctx = RequestContext.getCurrentContext();
        return (Boolean) ctx.getOrDefault(NEXT, true);
    }

    /**
     * 过滤方法
     *
     * @return
     * @throws ZuulException
     */
    @Override
    public Object run() throws ZuulException {
        context = RequestContext.getCurrentContext();
        return cRun();
    }

    protected abstract Object cRun();

    /**
     * 失败响应
     *
     * @param code 错误码
     * @param msg  错误信息
     * @return
     */
    Objects fail(Integer code, String msg) {
        context.set(NEXT, false);
        context.setSendZuulResponse(false);
        context.getResponse().setContentType("text/html;charset-UTF-8");
        context.setResponseStatusCode(code);
        context.setResponseBody(String.format("{\"result\": \"%s!\"}", msg));
        return null;
    }

    /**
     * 成功响应
     *
     * @return
     */
    Object success() {
        context.set(NEXT, true);
        return null;
    }
}

package org.szgb.console.config;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.szgb.console.utils.TokenUtil;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 登录检查
 * 1.配置到拦截器要拦截哪些请求
 * 2.把这些配置放在容器中
 * <p>
 * 实现HandlerInterceptor接口
 */
@Slf4j
@Component
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 目标方法执行之前
     * 登录检查写在这里，如果没有登录，就不执行目标方法
     *
     * @param request  请求对象，用于获取请求相关信息
     * @param response 响应对象，用于向客户端发送响应
     * @param handler  目标方法的处理器对象
     * @return 如果执行目标方法，则返回true；否则返回false
     * @throws Exception 可能抛出的异常
     */
    @Override
    public boolean preHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler) throws Exception {
        // 如果是OPTIONS请求，直接放行
        if (HttpMethod.OPTIONS.toString().equals(request.getMethod())) {
            return true;
        }
        // 获取进过拦截器的路径
        String requestURI = request.getRequestURI();
        // 如果请求路径包含"login"，直接放行
        if (requestURI.contains("login")) {
            return true;
        }
        // 登录检查逻辑
        String authHeader = request.getHeader("Authorization");
        // 如果Authorization头存在且以"Bearer "开头，进行token验证
        if (authHeader != null && authHeader.startsWith("Bearer ")) {
            String token = authHeader.substring(7); // 移除"Bearer "前缀
            // 验证token的有效性
            if (TokenUtil.verifyToken(token)) {
                // 从token中提取uid
                Integer uid = TokenUtil.getUid(token);
                // 将uid存储在request中，以便后续处理使用
                request.setAttribute("uid", uid);
                // 已登录，放行
                return true;
            }
        }
        // 未登录，返回401状态码
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
        return false;
    }

    /**
     * 在目标方法执行完成之后进行拦截处理
     * <p>
     * 此方法主要用于处理视图渲染前的准备，或是在请求处理完成后进行一些额外的操作
     * 例如：可以在此处添加请求耗时记录、日志输出等功能模块
     *
     * @param request      当前的HttpServletRequest对象，用于获取请求相关的信息
     * @param response     当前的HttpServletResponse对象，用于控制响应相关的信息
     * @param handler      当前请求的处理方法对象，可用于获取处理请求的具体实现
     * @param modelAndView ModelAndView对象，包含当前请求的视图和模型数据，可用于修改视图数据等
     * @throws Exception 如果处理过程中出现异常，将抛出Exception类型的异常
     */
    @Override
    public void postHandle(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, ModelAndView modelAndView) throws Exception {
        // 调用父类的postHandle方法，执行默认的处理逻辑
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }


    /**
     * 页面渲染以后
     * 该方法用作请求处理完成后的后期处理，主要用来处理请求结束后需要完成的一些清理工作，
     * 比如资源清理、记录日志等。通过覆盖此方法可以实现自定义的后期操作。
     *
     * @param request  请求对象，包含了请求的相关信息
     * @param response 响应对象，用于向客户端发送响应数据
     * @param handler  处理请求的具体处理器对象
     * @param ex       在处理请求过程中发生的异常，如果没有发生异常则为null
     * @throws Exception 可能抛出的异常，需要进行处理或捕获
     */
    @Override
    public void afterCompletion(@NonNull HttpServletRequest request, @NonNull HttpServletResponse response, @NonNull Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
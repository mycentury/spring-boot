package cn.himma.spring.boot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LanguageInterceptor implements HandlerInterceptor {

    private static final Logger logger = Logger.getLogger(LanguageInterceptor.class);

    /**
     * 视图渲染后
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object obj, Exception paramException) throws Exception {

    }

    /**
     * 请求处理完成后响应前
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object obj, ModelAndView modelAndView) throws Exception {
        if (modelAndView == null) {
            modelAndView = new ModelAndView();
        }
        String lang = LocaleContextHolder.getLocale().toString();
        modelAndView.addObject("lang", lang);
        logger.info("ModelAndView==>" + modelAndView);
    }

    /**
     * 请求接收后处理前
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object obj) throws Exception {
        // 获得请求地址
        StringBuffer requestUrl = request.getRequestURL();
        logger.info("request url ==>" + requestUrl);
        return true;
    }

}

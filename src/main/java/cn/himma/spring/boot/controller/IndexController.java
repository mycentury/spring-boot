/**
 * 
 */
package cn.himma.spring.boot.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年9月30日
 * @ClassName IndexController
 */
@Controller
public class IndexController {
    @RequestMapping({ "index" })
    public String index(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        // Locale locale1 = RequestContextUtils.getLocale(request);
        // Locale locale2 = LocaleContextHolder.getLocale();
        // System.out.println(locale1 + "," + locale2);
        String lang = LocaleContextHolder.getLocale().toString();
        map.put("lang", lang);
        map.put("static_keywords", "static_keywords");
        // map.put("dynamic_keywords", "dynamic_keywords");
        return "index";
    }

    @RequestMapping({ "/", "" })
    public String root(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        return "redirect:index";
    }

    @RequestMapping({ "/index2" })
    public String back(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        return "index2";
    }
}

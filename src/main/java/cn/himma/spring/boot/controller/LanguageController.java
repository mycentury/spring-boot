/**
 * 
 */
package cn.himma.spring.boot.controller;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.himma.spring.boot.vo.ResultVo;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年9月30日
 * @ClassName IndexController
 */
@Controller
public class LanguageController {
    @RequestMapping({ "/setLanguage" })
    public @ResponseBody ResultVo index(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        ResultVo res = new ResultVo();
        String lang = LocaleContextHolder.getLocale().toString();
        try {
            lang = request.getParameter("lang");
            Locale language = parseLanguage(lang);
            LocaleContextHolder.setLocale(language);
        } catch (Exception e) {
            res = new ResultVo(500, false, e.getMessage());
        }
        map.put("lang", lang);
        return res;
    }

    private Locale parseLanguage(String lang) {
        if (lang == null) {
            return Locale.CHINA;
        }
        lang = lang.trim();
        if (lang.startsWith("zh_CN")) {
            return Locale.CHINA;
        } else if (lang.startsWith("zh")) {
            return Locale.CHINESE;
        } else if (lang.startsWith("en_US")) {
            return Locale.US;
        } else if (lang.startsWith("en")) {
            return Locale.ENGLISH;
        }
        return Locale.CHINA;
    }
}

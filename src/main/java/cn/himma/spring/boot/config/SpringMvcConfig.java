/**
 * 
 */
package cn.himma.spring.boot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import cn.himma.spring.boot.interceptor.LanguageInterceptor;

/**
 * @Desc
 * @author wewenge.yan
 * @Date 2016年9月30日
 * @ClassName SpringConfig
 */
@Configuration
public class SpringMvcConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private LanguageInterceptor li;

    @Value("${interceptor.language.path}")
    private String languageInterceptorPath;

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        return new CookieLocaleResolver();
    }

    @Bean(name = "messageSource")
    public ResourceBundleMessageSource resourceBundleMessageSource() {
        ResourceBundleMessageSource source = new ResourceBundleMessageSource();
        source.setBasenames(new String[] { "i18n/index", "i18n/menu", "i18n/common" });
        return source;
    }

    @Bean
    public HandlerInterceptorAdapter getLocaleChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getLocaleChangeInterceptor());
        registry.addInterceptor(li).addPathPatterns(languageInterceptorPath);
    }
}

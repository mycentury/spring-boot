package cn.himma.spring.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Hello world!
 */
@SpringBootApplication(scanBasePackages = { "cn.himma.spring.boot" })
// @PropertySources({ @PropertySource("classPath:application.properties") }) 默认
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
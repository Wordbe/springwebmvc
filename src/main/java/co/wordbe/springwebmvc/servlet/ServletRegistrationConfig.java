package co.wordbe.springwebmvc.servlet;

import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@ServletComponentScan
@Configuration
public class ServletRegistrationConfig {

    @Bean
    public ServletRegistrationBean<MangoServlet> getServletRegistrationBean() {
        ServletRegistrationBean<MangoServlet> mangoServletBean = new ServletRegistrationBean<>(new MangoServlet());
        mangoServletBean.setName("mango");
        mangoServletBean.addUrlMappings("/mango");
        return mangoServletBean;
    }
}

package com.prepare.employee.configuration;

import com.prepare.employee.filters.LoggingFilter2;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomFilterConfig {
    @Bean
    public FilterRegistrationBean<LoggingFilter2> loggingFilterConfig(){
        FilterRegistrationBean<LoggingFilter2> registrationBean
                = new FilterRegistrationBean<>();

        registrationBean.setFilter(new LoggingFilter2());
        registrationBean.addUrlPatterns("/updateEmployee");

        return registrationBean;
    }
}

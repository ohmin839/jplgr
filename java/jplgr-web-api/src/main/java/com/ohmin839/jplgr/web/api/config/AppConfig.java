package com.ohmin839.jplgr.web.api.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {
    "com.ohmin839.jplgr.web.api.presentation.controller",
    "com.ohmin839.jplgr.web.api.application.service",
})
@Import({
    DatabaseConfig.class
})
public class AppConfig {

}
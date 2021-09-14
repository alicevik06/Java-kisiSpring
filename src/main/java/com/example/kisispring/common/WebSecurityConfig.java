package com.example.kisispring.common;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().
                authorizeRequests()
                .antMatchers("/api/blog/*").permitAll()
                .antMatchers("/api/etiket/*").permitAll()
                .antMatchers("/api/kategori/*").permitAll()
                .antMatchers("/api/yorum/*").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .permitAll();
    }
}
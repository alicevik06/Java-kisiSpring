package com.example.kisispring.webSecurityConfigurerAdapter;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.transaction.annotation.Transactional;

public class WebSecurityConfig implements IWebSecurityConfig {
    @Override


    protected void configure(HttpSecurity http) throws Exception {

        http.cors().and().csrf().disable().

                authorizeRequests()

                .antMatchers("/api/aktifKisi/*").permitAll()

                .antMatchers("/api/kisi/*").permitAll()

                .antMatchers("/api/yetkili/*").permitAll()


                .anyRequest().authenticated()

                .and()

                .formLogin()

                .permitAll();

    }

}


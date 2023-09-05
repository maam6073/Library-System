package com.rmsoft_test.LibrarySystem.common.security.config;

import com.rmsoft_test.LibrarySystem.common.security.login.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final UserDetailsServiceImpl userDetailsService;

    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers("/","/registry","/login").permitAll()
                .antMatchers("/h2-console/**").permitAll()
                .antMatchers("/users/**").authenticated() //일반사용자 접근 가능
                .antMatchers("/admin/**").hasAnyRole("ADMIN"); //관리자만 접근 가능

        http.headers().frameOptions().disable();
        http.formLogin().loginProcessingUrl("/login").defaultSuccessUrl("/",true);
        http.exceptionHandling().accessDeniedPage("/forbidden");
        http.logout().logoutUrl("logout").logoutSuccessUrl("/");
        http.userDetailsService(userDetailsService);
        return http.build();
    }
}

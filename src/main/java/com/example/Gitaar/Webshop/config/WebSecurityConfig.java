package com.example.Gitaar.Webshop.config;

import com.example.Gitaar.Webshop.security.JwtConfig;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@RequiredArgsConstructor
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private final JwtConfig jwtConfig;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .cors().and().csrf().disable().authorizeRequests()
                .and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers("/api/v1/auth/**",
                        "/api/v1/auth/login",
                        "/api/v1/registration/**",
                        "/api/v1/products/**",
                        "/api/v1/users/cart",
                        "/api/v1/users/order/**",
                        "/api/v1/users/review",
                        "/img/**",
                        "/static/**").permitAll()
                .antMatchers("/auth/**", "/oauth2/**", "/**/*swagger*/**", "/v2/api-docs").permitAll()
                .anyRequest().authenticated()
                .and()
                .oauth2Login()
                .and()
                .apply(jwtConfig);
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}

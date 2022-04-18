//package com.example.stronka;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.http.HttpMethod;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//
//@Configuration
//public class WebConfiguration implements WebMvcConfigurer {
//
//    public void configure(HttpSecurity http) throws Exception {
//        http.csrf().disable().authorizeRequests()
//                .antMatchers("/").permitAll()
//                .antMatchers(HttpMethod.POST,"/newuser").permitAll()
//                .antMatchers(HttpMethod.POST, "/login").permitAll()
//                .antMatchers(HttpMethod.POST,"/newuser/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/items/*").permitAll()
//                .antMatchers(HttpMethod.GET,"/getAllBooks").permitAll()
//                .anyRequest().authenticated();
//    }
//
//    @Bean
//    public PasswordEncoder encoder() {
//        return new BCryptPasswordEncoder();
//    }
//}

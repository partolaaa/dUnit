package com.willofd.dunit.config;

import com.willofd.dunit.services.impl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * @author Ivan Partola
 */

@Configuration
@EnableWebSecurity
public class SecurityConfig {
    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService){
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .formLogin(form -> form
                        .loginPage("/auth/login")
                        .usernameParameter("email")
                        .loginProcessingUrl("/perform_login")
                        .defaultSuccessUrl("/", true)
                        .failureUrl("/auth/login?error=true")
                        .permitAll());
        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/css/**", "/fonts/**", "/img/**", "/favicon.ico").permitAll()
                        .requestMatchers("/auth/register", "/auth/login", "", "/").permitAll()
                        .requestMatchers("/**").authenticated()
                        .anyRequest().authenticated());
        http
                .userDetailsService(userDetailsService);

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}

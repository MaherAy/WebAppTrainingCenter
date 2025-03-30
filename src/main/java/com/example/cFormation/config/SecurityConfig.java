package com.example.cFormation.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // Désactive CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("domaines","/roles","/employeurs","/formateurs","/formateurs/**","/utilisateurs","/utilisateurs/**","/participants","/participants/**", "/profiles/**","/structures" ,"/login", "/authenticate").permitAll() // Accès libre
                        .requestMatchers("/admin/**").hasRole("ADMIN") // Accès restreint
                        .anyRequest().authenticated() // Toute autre requête nécessite une authentification
                )
                .formLogin(form -> form
                        .loginPage("/login")
                        .permitAll()
                )
                .logout(logout -> logout.permitAll());

        return http.build();
    }


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
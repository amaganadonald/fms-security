package com.amagana.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.annotation.web.configurers.HeadersConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;


@EnableWebSecurity
@Configuration
@EnableMethodSecurity
public class SecurityConfig {

;
    private final JwtGrantedAuthoritiesConverters jwtGrantedAuthoritiesConverters;

    public SecurityConfig(JwtGrantedAuthoritiesConverters jwtGrantedAuthoritiesConverters) {
        this.jwtGrantedAuthoritiesConverters = jwtGrantedAuthoritiesConverters;
    }



    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity httpSecurty) throws Exception {
        return httpSecurty
                .csrf(AbstractHttpConfigurer::disable)
                .cors(Customizer.withDefaults())
                .authorizeHttpRequests(auth->auth.requestMatchers("/h2-console/**", "/api/v1/secure/authenticate").permitAll()
                        .anyRequest().authenticated())
                .formLogin(AbstractHttpConfigurer::disable)
                .sessionManagement(session->session.sessionCreationPolicy(
                        SessionCreationPolicy.STATELESS
                ))
                .oauth2ResourceServer(auth -> auth.jwt(
                        token -> token.jwtAuthenticationConverter(jwtGrantedAuthoritiesConverters)
                ))
                .headers(headers -> headers
                        .frameOptions(HeadersConfigurer.FrameOptionsConfig::disable) // Permet à H2 Console de s'afficher dans un iframe
                )
                .build();

    }
}

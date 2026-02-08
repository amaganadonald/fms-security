package com.amagana.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EntityScan("com.amagana.model")
@EnableJpaRepositories("com.amagana.repository")
public class JpaConfig {
}

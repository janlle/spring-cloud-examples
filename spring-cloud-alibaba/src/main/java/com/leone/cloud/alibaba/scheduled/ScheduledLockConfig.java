package com.leone.cloud.alibaba.scheduled;

import java.util.TimeZone;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import net.javacrumbs.shedlock.core.LockProvider;
import net.javacrumbs.shedlock.provider.jdbctemplate.JdbcTemplateLockProvider;

@Configuration
public class ScheduledLockConfig {

    @Autowired
    private DataSource dataSource;

    @Bean
    public LockProvider lockProvider() {
        return new JdbcTemplateLockProvider(JdbcTemplateLockProvider.Configuration.builder()
          .withJdbcTemplate(new JdbcTemplate(dataSource))
          .withTimeZone(TimeZone.getTimeZone("UTC"))
          .build());
    }

}
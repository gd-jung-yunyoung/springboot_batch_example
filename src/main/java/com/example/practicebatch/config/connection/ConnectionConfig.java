package com.example.practicebatch.config.connection;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class ConnectionConfig extends DefaultBatchConfigurer {

    @Override
    public void setDataSource(DataSource dataSource) {}

    @Bean("FirstDataSource")
    @Primary
    @ConfigurationProperties("spring.datasource.first.hikari")
    public HikariDataSource firstDbDataSource() {
        return DataSourceBuilder.create().type(HikariDataSource.class).build();

    }

}

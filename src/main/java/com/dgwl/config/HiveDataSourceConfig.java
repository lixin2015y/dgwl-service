package com.dgwl.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class HiveDataSourceConfig {


    @Bean(name = "hiveDataSource")
    @ConfigurationProperties(prefix = "hadoop.hive.datasource")
    public DataSource hiveDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "hiveJdbcTemplate")
    public JdbcTemplate hiveJdbcTemplate(
            @Qualifier("hiveDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }



}

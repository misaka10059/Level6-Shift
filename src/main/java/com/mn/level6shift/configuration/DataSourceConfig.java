package com.mn.level6shift.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
 * AUTHOR MisakaNetwork
 * DATE 2020/10/30 10:34
 * DESC
 */
@Configuration
@ConfigurationProperties(prefix = "spring.datasource.druid")
public class DataSourceConfig {

    /**
     * 主DataSource 配置
     */
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.druid.primary")
    @Bean(name = "primaryDataSource")
    @Qualifier("primaryDataSource")
    public DataSource primaryDruidDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }


    /**
     * 从DataSource 配置
     */
    @ConfigurationProperties(prefix = "spring.datasource.druid.secondary")
    @Bean(name = "secondaryDataSource")
    @Qualifier("secondaryDataSource")
    public DataSource slaveDruidDataSource() {
        return DataSourceBuilder.create().type(DruidDataSource.class).build();
    }

    @Autowired
    private Environment env;

    Map<String, String> getVendorProperties() {
        Map<String, String> jpaProperties = new HashMap<>(16);
        jpaProperties.put("hibernate.hbm2ddl.auto", "none");
        jpaProperties.put("hibernate.show_sql", env.getProperty("spring.jpa.show-sql"));
        jpaProperties.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
        jpaProperties.put("hibernate.format_sql", env.getProperty("spring.jpa.properties.hibernate.format_sql"));
        jpaProperties.put("hibernate.ejb.naming_strategy", env.getProperty("spring.jpa.properties.hibernate.ejb.naming_strategy"));
        jpaProperties.put("hibernate.current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
        return jpaProperties;
    }
}

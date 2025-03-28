package com.itlaoqi.multidatasource.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@Configuration
public class DataSourceConfig {
    //定义数据源1
    @Bean(name = "ds1")
    @ConfigurationProperties(prefix = "spring.datasource.ds1")
    public DataSource ds1() {
        return DataSourceBuilder.create().build();
    }

    //定义数据源2
    @Bean(name = "ds2")
    @ConfigurationProperties(prefix = "spring.datasource.ds2")
    public DataSource ds2() {
        return DataSourceBuilder.create().build();
    }

    //定义动态数据源
    @Bean(name = "dataSource")
    public DataSource dynamicDataSource(
            @Qualifier("ds1") DataSource ds1,
            @Qualifier("ds2") DataSource ds2
    ) {
        Map<Object, Object> targetDataSources = new HashMap<>();
        targetDataSources.put("ds1", ds1);
        targetDataSources.put("ds2", ds2);

        //实例化DynamicDataSource，设置数据源Map
        DynamicDataSource dynamicDataSource = new DynamicDataSource();
        dynamicDataSource.setTargetDataSources(targetDataSources);

        //设置默认数据源，未匹配上则使用默认数据源
        dynamicDataSource.setDefaultTargetDataSource(ds1);
        return dynamicDataSource;
    }

    @Bean
    public JdbcTemplate jdbcTemplate(@Qualifier("dataSource") DataSource ds){
        return new JdbcTemplate(ds);
    }
}

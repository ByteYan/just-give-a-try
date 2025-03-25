package com.itlaoqi.multidatasource.config;

import com.itlaoqi.multidatasource.common.DataSourceContextHolder;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * AbstractRoutingDataSource 的基本原理是，它维护了一个数据源的集合，每个数据源都有一个唯一的标识符。
 * 当应用程序需要访问数据库时，AbstractRoutingDataSource 会根据某种规则（例如请求的参数、用户的身份等）来选择一个合适的数据源，
 * 并将访问请求转发给这个数据源。
 */
public class DynamicDataSource extends AbstractRoutingDataSource {

    @Override
    protected Object determineCurrentLookupKey() {
        return DataSourceContextHolder.getDataSource();
    }

}

package com.catc.hive.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ConfigurationProperties(prefix = "hive")
@Getter
@Setter
public class HiveDruidConfig {
    @Value("${hive.url}")
    private String url;
    @Value("${hive.user}")
    private String user;
    @Value("${hive.password}")
    private String password;
    @Value("${hive.driver-class-name}")
    private String driverClassName;
    @Value("${hive.initialSize}")
    private int initialSize;
    @Value("${hive.minIdle}")
    private int minIdle;
    @Value("${hive.maxActive}")
    private int maxActive;
    @Value("${hive.maxWait}")
    private int maxWait;
    @Value("${hive.timeBetweenEvictionRunsMillis}")
    private int timeBetweenEvictionRunsMillis;
    @Value("${hive.minEvictableIdleTimeMillis}")
    private int minEvictableIdleTimeMillis;
    @Value("${hive.validationQuery}")
    private String validationQuery;
    @Value("${hive.testWhileIdle}")
    private boolean testWhileIdle;
    @Value("${hive.testOnBorrow}")
    private boolean testOnBorrow;
    @Value("${hive.testOnReturn}")
    private boolean testOnReturn;
    @Value("${hive.poolPreparedStatements}")
    private boolean poolPreparedStatements;
    @Value("${hive.maxPoolPreparedStatementPerConnectionSize}")
    private int maxPoolPreparedStatementPerConnectionSize;

    @Bean(name = "hiveDruidDataSource")
    @Qualifier("hiveDruidDataSource")
    public DataSource dataSource() {
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(user);
        datasource.setPassword(password);
        datasource.setDriverClassName(driverClassName);

        // pool configuration
        datasource.setInitialSize(initialSize);
        datasource.setMinIdle(minIdle);
        datasource.setMaxActive(maxActive);
        datasource.setMaxWait(maxWait);
        datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
        datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
        datasource.setValidationQuery(validationQuery);
        datasource.setTestWhileIdle(testWhileIdle);
        datasource.setTestOnBorrow(testOnBorrow);
        datasource.setTestOnReturn(testOnReturn);
        datasource.setPoolPreparedStatements(poolPreparedStatements);
        datasource.setMaxPoolPreparedStatementPerConnectionSize(
                maxPoolPreparedStatementPerConnectionSize);
        return datasource;
    }

    // 此处省略各个属性的get和set方法

    @Bean(name = "hiveDruidTemplate")
    public JdbcTemplate hiveDruidTemplate(
            @Qualifier("hiveDruidDataSource") DataSource dataSource) {
        return new JdbcTemplate(dataSource);
    }

}

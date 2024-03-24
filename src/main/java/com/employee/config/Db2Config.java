package com.employee.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EntityScan(basePackages = {"com.employee.entity.book"})
@EnableJpaRepositories(
        basePackages = {"com.employee.repository.book"},
        entityManagerFactoryRef = "bookEntityManagerFactory",
        transactionManagerRef = "bookTransactionManager"
)
public class Db2Config {

    @Bean(name = "bookDataSource")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource bookDataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "bookEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean bookEntityManagerFactory(
            EntityManagerFactoryBuilder builder,
            @Qualifier("bookDataSource") DataSource dataSource) {
        return builder
                .dataSource(dataSource)
                .packages("com.employee.entity.book")
                .persistenceUnit("book")
                .build();
    }

    @Bean(name = "bookTransactionManager")
    public PlatformTransactionManager bookTransactionManager(
            @Qualifier("bookEntityManagerFactory") LocalContainerEntityManagerFactoryBean entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory.getObject());
    }
}

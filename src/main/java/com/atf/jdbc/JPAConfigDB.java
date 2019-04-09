package com.atf.jdbc;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
@EnableJpaRepositories(basePackages = "com.atf",
        entityManagerFactoryRef = "ccEntityManager",
        transactionManagerRef = "ccTransactionManager")
public class JPAConfigDB {

    @Value("${jdbc.driver}")
    private String driver;

    @Value("${jdbc.hibernate.dialect}")
    private String dialect;

    @Value("${local.username}")
    private String username;

    @Value("${local.password}")
    private String password;

    @Value("${local.url}")
    private String url;

    @Bean(name = "localDataSource")
    public DataSource localDataSource(){
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

    @Bean(name = "ccTransactionManager")
    public PlatformTransactionManager ccTransactionManager(){
        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager();
        jpaTransactionManager.setEntityManagerFactory(ccEntityManager());
        return jpaTransactionManager;
    }

    @Bean(name = "ccEntityManager")
    public EntityManagerFactory ccEntityManager(){
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setPersistenceUnitName("persistence.cc");
        em.setDataSource(localDataSource());
        em.setPackagesToScan("com.atf");
        em.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        em.afterPropertiesSet();
        em.setJpaProperties(additionalProperties());
        return em.getObject();
    }

    public Properties additionalProperties() {
        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", dialect);
        return properties;
    }

}

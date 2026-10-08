package com.examen.examen1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
public class ConfiguracionBD {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setUrl("jdbc:postgresql://usuario_crud:CB8KWvWgQBIW1a2JfVYxsx2r0OuHtcm2@dpg-db0s3dk9v7es73cpoq8g-a/crud_db_ahlr");
        ds.setUsername("usuario_crud");
        ds.setPassword("CB8KWvWgQBIW1a2JfVYxsx2r0OuHtcm2");
        ds.setDriverClassName("org.postgresql.Driver");
        return ds;
    }

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(DataSource dataSource) {
        LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
        em.setDataSource(dataSource);
        em.setPackagesToScan("com.examen.examen1.model");

        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
        em.setJpaVendorAdapter(vendorAdapter);

        Properties propiedades = new Properties();
        propiedades.setProperty("hibernate.hbm2ddl.auto", "update");
        propiedades.setProperty("hibernate.show_sql", "true");
        em.setJpaProperties(propiedades);

        return em;
    }
}
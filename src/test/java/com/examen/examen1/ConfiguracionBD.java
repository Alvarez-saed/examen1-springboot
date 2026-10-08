package com.examen.examen1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

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
}
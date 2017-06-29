package io.egen;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Aastha Jain on 6/25/2017.
 */

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emf(){
        LocalContainerEntityManagerFactoryBean emf=new LocalContainerEntityManagerFactoryBean();
       //Mapping hibernate of persistence.xml to the JPAConfig class figure

        /* <property name="javax.persistence.jdbc.driver" value="com.mysql.cj.jdbc.Driver"></property>
            <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/studentrecords"></property>
            <property name="javax.persistence.jdbc.user" value="root"></property>
            <property name="javax.persistence.jdbc.password" value="root"></property>
            <property name="hibernate.hbm2ddl.auto" value="validate"></property>
            <property name="hibernate.show_sql" value="true"></property>*/

        emf.setDataSource(getDataSource());
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setPackagesToScan("io.egen.entity");  //Model classes

        Properties properties=new Properties();
        properties.put("hibernate.dialect","org.hibernate.dialect.MySQL57Dialect");
        properties.put("hibernate.hbm2ddl.auto","create");
        properties.put("hibernate.show_sql","true");
        emf.setJpaProperties(properties);
        return emf;
    }

    @Bean
    public DataSource getDataSource(){
        DriverManagerDataSource ds=new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/studentrecords?useSSL=false");
        ds.setUsername("root");
        ds.setPassword("root");
        return ds;
    }

    @Bean
    public JpaTransactionManager txManager(EntityManagerFactory entityManagerFactory){
        JpaTransactionManager transactionManager=new JpaTransactionManager(entityManagerFactory);
        return transactionManager;
    }

}
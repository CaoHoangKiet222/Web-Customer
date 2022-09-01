package com.web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// reference https://www.baeldung.com/hibernate-5-spring
/** HibernateConfig */
@Configuration
@EnableTransactionManagement
public class HibernateConfig {
  @Bean
  public DataSource dataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
    dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/web_customer_tracker");
    dataSource.setUser("springstudent");
    dataSource.setPassword("springstudent");
    dataSource.setInitialPoolSize(5);
    dataSource.setMinPoolSize(5);
    dataSource.setMaxPoolSize(20);
    dataSource.setMaxIdleTime(30000);
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
    LocalSessionFactoryBean session = new LocalSessionFactoryBean();
    session.setDataSource(dataSource());
    session.setPackagesToScan("com.web.model"); // look for annotated @Entity classes
    session.setHibernateProperties(hibernateProperties());
    return session;
  }

  @Bean
  public HibernateTransactionManager hibernateTransactionManager() throws PropertyVetoException {
    HibernateTransactionManager transactionManager = new HibernateTransactionManager();
    transactionManager.setSessionFactory(sessionFactory().getObject());
    return transactionManager;
  }

  private final Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    return hibernateProperties;
  }
}

package com.web.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import java.beans.PropertyVetoException;
import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// reference https://www.baeldung.com/hibernate-5-spring
/** HibernateConfig */
@Configuration
@EnableTransactionManagement
@PropertySource("classpath:resourcebundles/mysql.properties")
public class HibernateConfig {
  // -> https://www.baeldung.com/properties-with-spring
  @Autowired private Environment env;

  @Bean
  public DataSource dataSource() throws PropertyVetoException {
    ComboPooledDataSource dataSource = new ComboPooledDataSource();
    dataSource.setDriverClass(this.env.getProperty("jdbc.driver"));
    dataSource.setJdbcUrl(this.env.getProperty("jdbc.url"));
    dataSource.setUser(this.env.getProperty("jdbc.user"));
    dataSource.setPassword(this.env.getProperty("jdbc.password"));
    dataSource.setInitialPoolSize(this.getIntProperty("connection.pool.initialPoolSize"));
    dataSource.setMinPoolSize(this.getIntProperty("connection.pool.minPoolSize"));
    dataSource.setMaxPoolSize(this.getIntProperty("connection.pool.maxPoolSize"));
    dataSource.setMaxIdleTime(this.getIntProperty("connection.pool.maxIdleTime"));
    return dataSource;
  }

  @Bean
  public LocalSessionFactoryBean sessionFactory() throws PropertyVetoException {
    LocalSessionFactoryBean session = new LocalSessionFactoryBean();
    session.setDataSource(dataSource());
    session.setPackagesToScan(
        this.env.getProperty("hibernate.packagesToScan")); // look for annotated @Entity classes
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
    hibernateProperties.setProperty("hibernate.dialect", this.env.getProperty("hibernate.dialect"));
    hibernateProperties.setProperty(
        "hibernate.show_sql", this.env.getProperty("hibernate.show_sql"));
    return hibernateProperties;
  }

  private int getIntProperty(String key) {
    return Integer.parseInt(this.env.getProperty(key));
  }
}

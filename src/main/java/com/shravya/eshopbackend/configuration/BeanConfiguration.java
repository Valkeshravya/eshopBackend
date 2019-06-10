package com.shravya.eshopbackend.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
@Configuration
public class BeanConfiguration 
{
	public BeanConfiguration() {
		 System.out.println("config------------------------------------------");
	}
 @Bean(name="dataSource")
	public DataSource getDataSource()
	{
		BasicDataSource basicDataSource=new BasicDataSource();
		basicDataSource.setDriverClassName("org.h2.Driver");
		basicDataSource.setUrl("jdbc:h2:tcp://localhost/~/test/shravya");
		basicDataSource.setUsername("shravya");
		basicDataSource.setPassword("h2command");
		System.out.println("datasource");
		return basicDataSource;
	}
 @Bean
    public Properties getProperties()
    {
	 Properties properties=new Properties();
     properties.setProperty("hibernate.dialect","org.hibernate.dialect.H2Dialect");
     properties.setProperty("hibernate.show_sql","true");
     properties.setProperty("hibernate.hbm2ddl.auto","update");
     System.out.println("properties");
     return properties;
      }
 
 @Bean(name="sessionFactory")
 public SessionFactory  getSessionFactory()
 {
	 System.out.println("sessionfactory");
     LocalSessionFactoryBuilder localSessionFactoryBuilder=new LocalSessionFactoryBuilder(getDataSource());
     localSessionFactoryBuilder.addProperties(getProperties());
     localSessionFactoryBuilder.scanPackages("com.shravya.eshopbackend");
     System.out.println("sessionfactory");
     return  localSessionFactoryBuilder.buildSessionFactory();
                             
 }
 
 
 @Bean
 public HibernateTransactionManager getHibernateTransactionManager()
 {
     HibernateTransactionManager transactionManager=new HibernateTransactionManager(getSessionFactory());
 
     System.out.println("transactionManager");
     return transactionManager;
 } 
 
}


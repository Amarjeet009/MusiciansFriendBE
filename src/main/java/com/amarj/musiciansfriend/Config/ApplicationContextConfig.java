package com.amarj.musiciansfriend.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.amarj.musiciansfriend.model.Category;
import com.amarj.musiciansfriend.model.MyCart;
import com.amarj.musiciansfriend.model.Product;
import com.amarj.musiciansfriend.model.Supplier;
import com.amarj.musiciansfriend.model.User;

@Configuration
@ComponentScan("com.amarj.musiciansfriend")
@EnableTransactionManagement
public class ApplicationContextConfig {
	
	@Bean(name ="dataSource")
	public DataSource getH2DataSource(){
		
		DriverManagerDataSource dataSource= new DriverManagerDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/DTDB");
		dataSource.setUsername("sa");
		dataSource.setPassword("sa");
		
		return dataSource;
		
	}
	
	private Properties getHibernateProperties() {
		
		Properties properties=new Properties();
		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.dialect", "org.hibernate.dialect.H2Dialect");
		properties.put("Hibernate.hbm2ddl.auto","update");
		
		return properties;
		
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource)
	{
		
		LocalSessionFactoryBuilder sessionBuilder =new LocalSessionFactoryBuilder(dataSource);
		sessionBuilder.addProperties(getHibernateProperties());
		sessionBuilder.addAnnotatedClass(Category.class);
		sessionBuilder.addAnnotatedClass(User.class);
		sessionBuilder.addAnnotatedClass(Supplier.class);
		sessionBuilder.addAnnotatedClass(Product.class);
		sessionBuilder.addAnnotatedClass(MyCart.class);
		
		/*Used to scan all the class files in Model Package.*/
		/*sessionBuilder.scanPackages(com.amarj.musiciansfriend.model);*/
		
		return sessionBuilder.buildSessionFactory();
		
		 
		
	}
	
   @Autowired
   @Bean(name="transactionManager")
    
   public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

		return transactionManager;
	}

}

package web.shop.shoponlinebackend.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan({"web.shop.shoponlinebackend.dto"})
@EnableTransactionManagement
public class HibernateConfig {

	//change the below information based on your DBMS requirement
	private final static String DATABASE_URL="jdbc:h2:tcp://localhost/~/shopononline";
	private final static String DATABASE_USERNAME="root";
	private final static String DATABASE_DIALECT="org.hibernate.dialect.H2Dialect";
	private final static String DATABASE_DRIVER="org.h2.driver";
	private final static String DATABASE_PASSWORD="";
	
	//DataSource Bean will be available
	@Bean
	public DataSource getDataSource(){
		BasicDataSource dataSource=new BasicDataSource();
		//providing database connection information
		dataSource.setDriverClassName(DATABASE_DRIVER);
		dataSource.setUsername(DATABASE_USERNAME);
		dataSource.setUrl(DATABASE_URL);
		dataSource.setPassword(DATABASE_PASSWORD);
				
		return dataSource;  
	}
	//SessionFactory Bean will be available
	@Bean
	public SessionFactory getSessionFactory(DataSource dataSource){
		LocalSessionFactoryBuilder builder=new LocalSessionFactoryBuilder(dataSource);
		builder.addProperties(getHibernateProperties());
		builder.scanPackages("web.shop.shoponlinebackend.dto");
		return builder.buildSessionFactory();
	}
	//All the hibernate properties will be returned in this method
	private Properties getHibernateProperties() {
		Properties properties=new Properties();
		properties.put("hibernate.dialect", DATABASE_DIALECT);
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");

		return properties;
	}
	
	//HibernateTransactionManager bean
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sf){
		HibernateTransactionManager transactionManager=new HibernateTransactionManager(sf);
		return transactionManager;
	}
	
}

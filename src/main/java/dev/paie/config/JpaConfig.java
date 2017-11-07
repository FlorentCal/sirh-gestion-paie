package dev.paie.config;

import java.util.Properties;
import java.util.ResourceBundle;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author Florent Callaou
 * Configuration des base (cf pom.xml et app.properties)
 */
@Configuration
@EnableTransactionManagement
public class JpaConfig {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("app");
	
	String dialect = resourceBundle.getString("hibernate.dialect");
	String schemaGenerationDbAction = resourceBundle.getString("schema-generation.database.action");
	
	@Bean
	public PlatformTransactionManager transactionManager(EntityManagerFactory emf) {
		JpaTransactionManager txManager = new JpaTransactionManager();
		txManager.setEntityManagerFactory(emf);
		return txManager;
	}
	
	@Bean
	// Cette configuration nécessite une source de données configurée.
	// Elle s'utilise donc en association avec un autre fichier de configuration définissant un bean DataSource.
	public EntityManagerFactory entityManagerFactory(DataSource dataSource) {
		HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
		// activer les logs SQL
		vendorAdapter.setShowSql(true);
		LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
		factory.setJpaVendorAdapter(vendorAdapter);
		// alternative au persistence.xml
		factory.setPackagesToScan("dev.paie.entite");
		factory.setDataSource(dataSource);
		
		Properties jpaProperties = new Properties();
		jpaProperties.setProperty("javax.persistence.schema-generation.database.action", schemaGenerationDbAction);
		jpaProperties.setProperty("hibernate.dialect", dialect);
		jpaProperties.setProperty("hibernate.enable_lazy_load_no_trans", "true");
		factory.setJpaProperties(jpaProperties);
		factory.afterPropertiesSet();
		return factory.getObject();
	}
}

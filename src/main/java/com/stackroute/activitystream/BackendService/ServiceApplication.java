package com.stackroute.activitystream.BackendService;
//package name should not contain captial letter

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.orm.jpa.vendor.HibernateJpaSessionFactoryBean;




//@ComponentScan(basePackages= {"com.stackroute.activitystream"})
@SpringBootApplication(scanBasePackages={"com.stackroute.activitystream"})
@EntityScan(basePackages={"com.stackroute.activitystream.model"})
@EnableAutoConfiguration
public class ServiceApplication {

	@Bean
	public HibernateJpaSessionFactoryBean sessionFactory() {
	    return new HibernateJpaSessionFactoryBean();
	}
	
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceApplication.class, args);
	}
}

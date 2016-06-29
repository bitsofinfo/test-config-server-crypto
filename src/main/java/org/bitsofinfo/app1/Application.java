package org.bitsofinfo.app1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;

import org.springframework.beans.factory.annotation.Value;

@SpringBootApplication(exclude = {
		  DataSourceAutoConfiguration.class, 
		  HibernateJpaAutoConfiguration.class})
@EnableConfigServer
public class Application {
	
	@Autowired
	private Environment environment;

	@Value("${test.crypted.prop}")
        private String myValue ;
	
	private static Environment env;

    public static void main(String[] args) throws Exception {
       SpringApplication.run(new Class[]{Application.class}, args);
   	
       System.out.println(env.getProperty("test.clear.prop"));
       System.out.println(env.getProperty("test.crypted.prop"));
   	

    }
    
    @Bean
    public Object bean1() {
    	env = environment;
        System.out.println(this.myValue);
    	return env;
    }
  
}

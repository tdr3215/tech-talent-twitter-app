package com.techtalentsouth.TechTalentTwitter.configuration;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfiguration implements WebMvcConfigurer{
	

//	@Bean
//	UserDetailsManager users(DataSource dataSource) {
//		UserDetails user = User.builder()
//				  .username("user")
//				  .password("password")
//				  .roles("USER")
//				  .build();
//		JdbcUserDetailsManager users = new JdbcUserDetailsManager(dataSource);
//		users.createUser(user);
//		
//		return users;
//	}
	
    @Bean
    BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder bCryptPasswordEncoder = 
            new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }
    


}

package com.wikitrends.front;

import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@EnableWebSecurity
	@Configuration
	@EnableGlobalMethodSecurity(prePostEnabled=true)
	public class SecurityConfig extends WebSecurityConfigurerAdapter {

	  @Override
	  protected void registerAuthentication(AuthenticationManagerBuilder auth) throws Exception {
	    auth.inMemoryAuthentication()
	        .withUser("spam").password("sp3m").roles("USER");
	  }

	  @Override
	  protected void configure(HttpSecurity http) throws Exception {
	    http.authorizeUrls()
	        .antMatchers("/spamfront-1/**").hasRole("USER")
	        .antMatchers("/spamweb").hasRole("USER")
	        .anyRequest().anonymous()
	        .and()
	        //This will generate a login form if none is supplied.
	        .formLogin();
	  }

	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	       return super.authenticationManagerBean();
	  }
	}
	
	
}

package com.calisma.spsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired DriverManagerDataSource dataSource;
	
	// bu fnc mail ve şifre bilgilerin alıp vt ye sorgulamak için kullanılır.
	// "" ifade içinde SQL sorgusu kullanılır.
	// authoritiesByUsernameQuery -> mail ve role varlığı kontrolü yapar
	// usersByUsernameQuery -> password ve aktif kullanıcı kontrolü yapar.
	// 2 durum içinde parametre olarak mail(kullanıcı adı) gelir.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
		.authoritiesByUsernameQuery(" select amail, role from admin where amail = ? ")
		.usersByUsernameQuery(" select amail, apass, 1 from admin where amail = ? ");
	}
	
	// uygulamanın hangi giriş yöntemi ile çalışacağına karar verir.
	// role bağlı olarak hangi rolün hangi işlemi yapacağına karar verir.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
		.httpBasic()
		.and()
		.authorizeRequests()
		
		.antMatchers("/allAdmins").hasAnyAuthority("Admin")
		.antMatchers("/allBlogs").hasAnyAuthority("Admin","User")
		.antMatchers("/allCarts").hasAnyAuthority("Admin","User")
		.antMatchers("/allContacts").hasAnyAuthority("Admin","User")
		.antMatchers("/allFoods").hasAnyAuthority("Admin","User")
		.antMatchers("/allNeworders").hasAnyAuthority("Admin","User")
		.antMatchers("/allUsers").hasAnyAuthority("Admin","User")
		.anyRequest()
		.authenticated()
		.and()
		.csrf().disable();
		
	}
	
	
	@SuppressWarnings("deprecation")
	@Bean
	public static NoOpPasswordEncoder passwordEncoder() {
		return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
	}
	
	
}

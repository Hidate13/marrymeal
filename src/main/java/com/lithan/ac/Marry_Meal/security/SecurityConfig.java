package com.lithan.ac.Marry_Meal.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsServiceImpl();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    	System.out.println("At Authen configure");
        auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
    	System.out.println("At Security configure");
        http
        		
                .formLogin()
                    .loginPage("/cus_login_page")
                    .loginProcessingUrl("/login")
                    .failureUrl("/login_error")
                    .permitAll()
                    .defaultSuccessUrl("/welcome", true)
                .and()
                .csrf()
                .and()
                .authorizeRequests()
                    .antMatchers("/").permitAll()
                    .antMatchers("/css/**").permitAll()
                    .antMatchers("/images/**").permitAll()
                    .antMatchers("/js/**").permitAll()
                    .antMatchers(HttpMethod.GET, "/favicon.*").permitAll()
                    .antMatchers(HttpMethod.GET, "/login").permitAll()
                    .antMatchers(HttpMethod.GET, "/search").hasAnyRole("Partner","Member","Administrator")
                    .antMatchers(HttpMethod.GET, "/view_meals").hasAnyRole("Partner","Member","Administrator")
                    .antMatchers(HttpMethod.GET, "/meals").hasAnyRole("Partner","Member","Administrator")
                    .antMatchers(HttpMethod.GET,"/new_meal").hasRole("Partner")
                    .antMatchers(HttpMethod.GET,"/delivery").hasRole("Administrator")
                    .antMatchers(HttpMethod.GET,"/vollunteer").hasRole("Volunteer")
                    .antMatchers(HttpMethod.GET,"/take_over").hasRole("Volunteer")
                    .antMatchers(HttpMethod.GET,"/order").hasRole("Member")
                    .antMatchers(HttpMethod.POST, "/meals").hasAnyRole("Partner","Administrator")
                    .antMatchers(HttpMethod.GET,"/edit").hasRole("Administrator")
                    .antMatchers(HttpMethod.GET,"/edit").hasRole("Partner")
                    .antMatchers(HttpMethod.PUT, "/new_meal").hasAnyRole("Partner","Administrator")
                    .antMatchers(HttpMethod.GET, "/delete").hasRole("Administrator")
                    .antMatchers(HttpMethod.GET, "/delete").hasRole("Partner")
                    .antMatchers(HttpMethod.DELETE, "/delete").hasRole("Administrator")
                    .antMatchers(HttpMethod.DELETE, "/delete").hasRole("Partner")
                    .antMatchers(HttpMethod.GET,"/users").hasRole("Administrator")
                .and()
                .logout()
                    .logoutSuccessUrl("/cus_login_page")
                    .invalidateHttpSession(true);
                  
    }
}

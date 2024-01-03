package org.cb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    //Authentication
    @Bean
    public UserDetailsService userDetails(DataSource dataSource){
        var user = User.withUsername("SAM").password("$2a$10$H1D/gPE/tzPgr2RhqDCniOz1GS5YhSfnXxtzM6aPVeq/erTTWONTC").authorities("ADMIN").build();
        var user1 = User.withUsername("RAM").password("$2a$10$k66j7yCfR.35KsrstsgPjO9uBO0BjN9ah4eXfl29RaHz8yMFWrwya").authorities("CUSTOMER").build();
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);
        jdbcUserDetailsManager.createUser(user);
        jdbcUserDetailsManager.createUser(user1);
//        jdbcUserDetailsManage¥r
        return jdbcUserDetailsManager;
    }

    //Authorization
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(request-> request.requestMatchers("/home").permitAll()
                        .requestMatchers("/hello").authenticated()
                        .requestMatchers("/admin").hasAuthority("ADMIN")
                        .requestMatchers("/customer").hasAuthority("CUSTOMER")
                )
                .formLogin( form -> form.loginPage("/login")
                        .defaultSuccessUrl("/hello").permitAll())
                .logout(logout-> logout.logoutUrl("/logout").permitAll())
                .build();
//        return null;
    }

}

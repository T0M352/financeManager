package tomaszmorgas.financemanager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/showFormForUpdate").hasRole("MODERATOR")
                        .requestMatchers("/products/menu").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/list").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/showNotShippedYet").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/showTimeRangeListForm").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/showStatisticTimeForm").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/showFormForAdd").hasRole("MODERATOR")
                        .requestMatchers("/products/save").hasRole("MODERATOR")
                        .requestMatchers("/products/showListOfDateRange").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/showStats").hasAnyRole("NORMALUSER", "MODERATOR")
                        .requestMatchers("/products/delete").hasRole("MODERATOR")
                        .anyRequest().authenticated()
                )
                .formLogin(form ->
                        form
                                .loginPage("/showLoginPage")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/access-denied")
                );
        return http.build();
    }



//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager(){
//        UserDetails normalUser = User.builder()
//                .username("normalUser")
//                .password("{noop}test123")
//                .roles("NORMALUSER")
//                .build();
//
//        UserDetails modUser = User.builder()
//                .username("modUser")
//                .password("{noop}test123")
//                .roles("NORMALUSER", "MODERATOR")
//                .build();
//
//        return new InMemoryUserDetailsManager(normalUser, modUser);
//
//    }
}

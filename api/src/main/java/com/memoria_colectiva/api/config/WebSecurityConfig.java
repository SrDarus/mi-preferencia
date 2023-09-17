package com.memoria_colectiva.api.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;





@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    private Logger logger = LoggerFactory.getLogger(WebSecurityConfig.class);

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        logger.info("******SecurityFilterChain*******");
        http
				.authorizeHttpRequests((authorize) -> authorize
                    .requestMatchers("/public/**").permitAll()
                    .requestMatchers("/admin/**").hasRole("ADMIN")
                    .anyRequest().authenticated()
				)
				.httpBasic(withDefaults())
				.formLogin(withDefaults());

        return http.build();
    }

    @Bean
	public UserDetailsService users() {
        logger.info("******InMemoryUserDetailsManager*******");

        var adminPass = new BCryptPasswordEncoder().encode("Caradej1");
        logger.info("******adminPass*******");
        logger.info(adminPass);

        var userPass = new BCryptPasswordEncoder().encode("leonardo22");
		UserDetails admin = User
            .builder()
            // // .withDefaultPasswordEncoder()
			.username("darus")
			.password("{bcrypt}"+adminPass)
			.roles("ADMIN")
			.build();

        UserDetails user = User
            .builder()
            // .withDefaultPasswordEncoder()
			.username("cindy")
			.password("{bcrypt}"+userPass)
			.roles("USER")
			.build();
		return new InMemoryUserDetailsManager(admin, user);
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        // return new BCryptPasswordEncoder();
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }


    // @Bean
    // UserDetailServiceImp userDetailService() {
    //     logger.info("******UserDetailServiceImp*******");

    //     return new UserDetailServiceImp();
    // }


}

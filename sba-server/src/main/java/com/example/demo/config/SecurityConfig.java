package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;

import de.codecentric.boot.admin.server.config.AdminServerProperties;
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	private final AdminServerProperties adminServer;

    public SecurityConfig(AdminServerProperties adminServer) {
        this.adminServer = adminServer;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        SavedRequestAwareAuthenticationSuccessHandler successHandler = new SavedRequestAwareAuthenticationSuccessHandler();
        successHandler.setTargetUrlParameter("redirectTo");
        successHandler.setDefaultTargetUrl(this.adminServer.path("/"));

        http.authorizeRequests()
            .antMatchers(this.adminServer.path("/assets/**")).permitAll() // <1>
            .antMatchers(this.adminServer.path("/login")).permitAll()
            .anyRequest().authenticated() // <2>
            .and()
        .formLogin().loginPage(this.adminServer.path("/login")).successHandler(successHandler).and() // <3>
        .logout().logoutUrl(this.adminServer.path("/logout")).and()
        .httpBasic().and() // <4>
        .csrf()
            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse()) // <5>
            .ignoringAntMatchers(
                this.adminServer.path("/instances"), // <6>
                this.adminServer.path("/actuator/**") // <7>
            );
    }
}

package com.zazdravnykh.inventorylist.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.RegexRequestMatcher;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    @Qualifier("dataSource")
    DataSource dataSource;

    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username,password, enabled from inventoryusers where username=?")
                .authoritiesByUsernameQuery("SELECT u.username, r.role FROM inventoryusers u INNER JOIN users_roles ur ON u.id = ur.user_id" +
                                                                                            " INNER JOIN roles r ON ur.role_id = r.id" +
                                                                                            " WHERE u.username = ?");

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        RequestMatcher csrfMatcher = new RequestMatcher() {


            RegexRequestMatcher[] requestMatchers = new RegexRequestMatcher[] {
              new RegexRequestMatcher("/addItem","POST",false),
              new RegexRequestMatcher("/deleteItem/.*","POST",false),
              new RegexRequestMatcher("/updateItem/.*","POST",false)
            };


            @Override
            public boolean matches(HttpServletRequest request) {

                for (RegexRequestMatcher requestMatcher : requestMatchers)
                {
                    if (requestMatcher.matches(request))
                        return true;
                }
                return false;
            }
        };

        http.csrf().requireCsrfProtectionMatcher(csrfMatcher).and()
                .authorizeRequests()
                .antMatchers("/legal","/addUser")
                .hasRole("ADMIN")
                .anyRequest()
                .permitAll()
                .and()
                .formLogin()
                .permitAll();
    }




}

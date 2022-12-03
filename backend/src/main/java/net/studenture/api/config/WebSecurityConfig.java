package net.studenture.api.config;

import net.studenture.api.entities.Role;
import net.studenture.api.entities.User;
import net.studenture.api.repositories.UserGoogleRepository;
import net.studenture.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.boot.autoconfigure.security.oauth2.resource.PrincipalExtractor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.oauth2.client.filter.OAuth2ClientContextFilter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableOAuth2Sso
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

   @Autowired
   UserGoogleRepository userGoogleRepository;

    @Autowired
    UserRepository userRepository;

    //google authorization
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/").permitAll()
                .anyRequest().authenticated()
                .and()
                .csrf().disable();
    }

    @Bean
    public PrincipalExtractor principalExtractor(UserGoogleRepository userGoogleRepository) {
        return map -> {
            String id = (String) map.get("sub");

            User user = userGoogleRepository.findById(id).orElseGet(() -> {
            User newUser = new User();
            newUser.setId(id);
            newUser.setName((String) map.get("name"));
            newUser.setEmail((String) map.get("email"));
            newUser.setRole(String.valueOf(Role.USER));
            //newUser.setRoles(Collections.singleton(Role.USER));
            System.out.println(newUser);
            return newUser;
             });
            return userGoogleRepository.save(user);

        };
    }

    //login autorization


    @Override
    @Bean
    public UserDetailsService userDetailsService() {
        UserDetails user =
                org.springframework.security.core.userdetails.User.builder()
                        .username("user")
                        .password("password")
                        .roles("USER")
                        .build();

        return new InMemoryUserDetailsManager(user);
    }


}
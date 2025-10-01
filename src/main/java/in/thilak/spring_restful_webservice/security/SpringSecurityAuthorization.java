package in.thilak.spring_restful_webservice.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityAuthorization {

    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        // All requests should be authenticated
         http.authorizeHttpRequests(
            auth -> auth.anyRequest().authenticated());
        // if any request is not authenticated, show login form
        http.httpBasic(withDefaults -> {});
        //disable CSRF for POST, PUT, DELETE requests
        http.csrf(csrf -> csrf.disable());
        return http.build();
    }
}

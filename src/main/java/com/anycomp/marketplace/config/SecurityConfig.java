package com.anycomp.marketplace.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/**").permitAll()
                .anyRequest().permitAll()
            );
        return http.build();
    }
}

/*Getting a 401 Unauthorized in Postman because Spring Security is enabled by default
 in all Spring Boot applications that include the spring-boot-starter-security 
 dependency — even if you didn’t configure any authentication logic.

Here's why you need to explicitly disable or configure it: 

By default, Spring Security:
-Protects all endpoints (like /api/buyers).
-Requires authentication (basic auth using a generated password).
-Shows a 401 Unauthorized if no credentials are provided.


1. Disables authentication for /api/**:
So your frontend (Next.js) and Postman can access the backend without needing login.

2. Disables CSRF protection:
CSRF is useful for web forms, but for API
 requests (especially from Postman or a frontend on a different port like Next.js),
  it gets in the way unless disabled.

3. Ensures smooth local dev experience:
You don’t want to be bothered with login setup during early development or testing in Postman.

Summary: You should add this SecurityConfig so that:
-Your /api/buyers endpoint works in Postman.
-You can connect Next.js frontend without auth issues.
-You don’t get unexpected 401 errors while testing.

You should configure Spring Security explicitly for the following reasons:
-Development Convenience: To disable or relax security temporarily so Postman or frontend (Next.js) 
can access your endpoints without login.
-Controlled Access: You can later configure fine-grained access—for example,
 allowing public access to GETs but requiring login for POST/DELETE.
-Production Readiness: For real deployment, you’ll eventually 
want proper authentication (e.g. JWT tokens, sessions, or OAuth2).

*/ 
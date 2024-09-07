package pl.learning.Configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import pl.learning.Data.UserRole;

@Configuration
public class SecurityConfig {
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(request ->
                        request
                                .requestMatchers("/api/v1/user/register","/api/v1/user/login").permitAll()
                                .requestMatchers("/api/v1/user/updateEmail").hasAnyRole(UserRole.TEACHER.toString(), UserRole.STUDENT.toString())
                                .requestMatchers("/api/v1/admin/**").hasRole(UserRole.ADMIN.toString())
                                .anyRequest().authenticated()
                );
        return http.build();
    }


}

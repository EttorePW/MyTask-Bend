package MyTaskApp.MyTaskList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**") // Permitir todos los endpoints
                        .allowedOrigins(
                            "https://mytaskssoft.netlify.app", // tu frontend
                            "http://localhost:3000", // desarrollo local
                            "http://localhost:5173", // Vite dev server
                            "*" // Temporalmente permitir todos los orígenes para debug
                        )
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*")
                        .allowCredentials(false); // Cambiar a false cuando usas "*" origins
            }
        };
    }
}

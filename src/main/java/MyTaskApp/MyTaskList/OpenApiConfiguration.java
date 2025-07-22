package MyTaskApp.MyTaskList;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfiguration {
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("My Task API")
                        .description("Dokumentation für das My TASK-Backend")
                        .version("1.0").contact(new Contact()
                                .name("Ettore Junior Pesendorfer-Wagner")
                                .email("ettore.pw@gmail.com")
                        )
                );
    }

}

package com.api.todolist.config;


import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI productApiOpenAPI() {
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("sever of development");

        Contact contact = new Contact();
        contact.setEmail("leukefackchristian@gmail.com");
        contact.setName("gremmy expert AI");
        contact.setUrl("https://www.gremmythou.com");

        License license = new License()
                .name("IUC License")
                .url("https://kmergenius.com/licenses/iuc/");

        Info info = new Info()
                .title("API TODO LIST")
                .version("1.0.0")
                .contact(contact)
                .description("this API permit of manage the tasks with all the operations of CRUD.")
                .termsOfService("https://www.iuc.com/terms")
                .license(license);

        return new OpenAPI()
                .info(info)
                .servers(List.of(server));
    }
}
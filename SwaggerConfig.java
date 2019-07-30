@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.tuturself.webservice"))
                .paths(PathSelectors.any())
                .build().apiInfo(metaData())
                .useDefaultResponseMessages(false);
    }

    private ApiInfo metaData() {
        return new ApiInfoBuilder()
                .title("Spring Boot 2.0 File Upload example with Consul Integration & Swagger 2.8.0")
                .description("Upload file with Swagger-ui 2.8.0 using Spring Boot 2.0 Spring Cloud Consul")
                .version("version 1.0")
                .contact(new Contact("Tutu'rself", "https://www.tuturself.com", "arpan.kgp@gmail.com"))
                .build();
    }
}

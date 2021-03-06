package com.zensar.blog;

import org.modelmapper.ModelMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.License;

@SpringBootApplication
//@OpenAPIDefinition(info = @Info(title = "Blog Application",version = "v1",description = "You can Read the blog  and Comment on Post"))
public class SpringBootBlogAppApplication extends SpringBootServletInitializer implements CommandLineRunner {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootBlogAppApplication.class, args);

		/*
		 * ConfigurableApplicationContext context =
		 * SpringApplication.run(SpringBootBlogAppApplication.class, args);
		 * PostController
		 * postController=context.getBean("postController",PostController.class);
		 * 
		 * PostDto post1 = new PostDto(); post1.setId(1L); post1.setTitle("Test title");
		 * post1.setDescription("Test Description"); post1.setContent("Test");
		 * 
		 * 
		 * postController.createPost(post1);
		 */
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return super.configure(builder);
	}

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * PostDto post1 = new PostDto(); post1.setId(1L); post1.setTitle("Test title");
		 * post1.setDescription("Test Description"); post1.setContent("Test");
		 * 
		 * PostDto post2 = new PostDto(); post2.setId(2L);
		 * post2.setTitle("Test title2"); post2.setDescription("Test Description2");
		 * post2.setContent("Test2"); postController.createPost(post1);
		 * postController.createPost(post2);
		 */
	}

	@Bean
	  public OpenAPI springShopOpenAPI() {
	      return new OpenAPI()
	              .info(new io.swagger.v3.oas.models.info.Info().
	            		  title("Blog App").
	            		  description("Blog sample application").
	            		  version("v0.0.1").
	            		  license(new License().name("Apache 2.0").
	            				  url("http://springdoc.org")));
     
	  }

}

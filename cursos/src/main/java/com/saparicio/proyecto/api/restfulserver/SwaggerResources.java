package com.saparicio.proyecto.api.restfulserver;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * <div>
 * <p>
 *  Esta clase carga los recursos necesarios para la ejecucion del swagger-ui.
 * </p>
 * </div>
 * 
 * @author Sergio aparicio.
 * 
 */

@Configuration
@EnableWebMvc
public class SwaggerResources extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		
		registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");

		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	 
	}

	
	
}

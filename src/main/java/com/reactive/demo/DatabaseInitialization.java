package com.reactive.demo;

import io.r2dbc.spi.ConnectionFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.r2dbc.connection.init.CompositeDatabasePopulator;
import org.springframework.r2dbc.connection.init.ConnectionFactoryInitializer;
import org.springframework.r2dbc.connection.init.ResourceDatabasePopulator;

import java.nio.charset.StandardCharsets;

@Slf4j
@Configuration
public class DatabaseInitialization extends SpringBootServletInitializer {
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(DemoApplication.class);
	}

	@Bean
	public ConnectionFactoryInitializer initializer(ConnectionFactory connectionFactory) {
		log.info("=============== INICIALIZACIÓN BASE DE DATOS ======================");

		ConnectionFactoryInitializer initializer = new ConnectionFactoryInitializer();
		initializer.setConnectionFactory(connectionFactory);

		CompositeDatabasePopulator populator = new CompositeDatabasePopulator();

		ResourceDatabasePopulator resourceDatabasePopulatorSchema = new ResourceDatabasePopulator(new ClassPathResource("db/schema.sql"));
		resourceDatabasePopulatorSchema.setSqlScriptEncoding(StandardCharsets.UTF_8);
		populator.addPopulators(resourceDatabasePopulatorSchema);

		ResourceDatabasePopulator resourceDatabasePopulatorData = new ResourceDatabasePopulator(new ClassPathResource("db/data.sql"));
		resourceDatabasePopulatorData.setSqlScriptEncoding(StandardCharsets.UTF_8);
		populator.addPopulators(resourceDatabasePopulatorData);

		initializer.setDatabasePopulator(populator);
		return initializer;
	}
}

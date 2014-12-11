package br.com.lnprojetos.bpplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;

import com.mongodb.Mongo;
import com.mongodb.WriteConcern;

@ComponentScan
@EnableAutoConfiguration
@EnableMongoRepositories
@EnableHypermediaSupport(type = HypermediaType.HAL)
public class Application extends AbstractMongoConfiguration{
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Override
	protected String getDatabaseName() {
		return "bpplanner";
	}

	@Bean
	public Mongo mongo() throws Exception {
		@SuppressWarnings("deprecation")
		Mongo mongo = new Mongo();
		mongo.setWriteConcern(WriteConcern.SAFE);

		return mongo;
	}
}
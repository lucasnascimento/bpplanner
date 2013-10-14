package br.com.lnprojetos.bpplanner.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.RepositoryLinksResource;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;

import br.com.lnprojetos.bpplanner.repository.Projeto;

@Configuration
public class WebConfiguration extends RepositoryRestMvcConfiguration {
	@Bean
	public ResourceProcessor<Resource<Projeto>> personResourceProcessor() {
		return new ResourceProcessor<Resource<Projeto>>() {
			RepositoryRestConfiguration config = config();

			@Override
			public Resource<Projeto> process(Resource<Projeto> resource) {
				System.out.println("processing " + resource);
				System.out.println("url: " + config.getBaseUri().toString());
				resource.add(new Link("http://host:port/path", "myrel"));
				return resource;
			}
		};
	}

	@Bean
	public ResourceProcessor<RepositoryLinksResource> rootLinksResourceProcessor() {
		return new ResourceProcessor<RepositoryLinksResource>() {
			@Override
			public RepositoryLinksResource process(RepositoryLinksResource resource) {
				resource.add(new Link("href", "rel"));
				return resource;
			}
		};
	}
}
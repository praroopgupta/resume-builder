package com.pg.resumebuilder;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@EnableDiscoveryClient
@SpringBootApplication
public class ResumeBuilderApplication {

	public static void main(String[] args) {
		SpringApplication.run(ResumeBuilderApplication.class, args);
	}
	
	@Bean
	public Sampler defaultSampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
	
	/*
	 * @Bean 
	 * public LocaleResolver localeResolver() { AcceptHeaderLocaleResolver
	 * localeResolver = new AcceptHeaderLocaleResolver();
	 * localeResolver.setDefaultLocale(Locale.US); return localeResolver; }
	 */
	
	/*
	 * @Bean 
	 * public ResourceBundleMessageSource bundleMessageSource() {
	 * ResourceBundleMessageSource messageSource = new
	 * ResourceBundleMessageSource(); messageSource.setBasename("messages"); return
	 * messageSource;
	 * 
	 * }
	 */

}

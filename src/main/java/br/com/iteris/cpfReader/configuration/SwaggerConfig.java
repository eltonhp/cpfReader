package br.com.iteris.cpfReader.configuration;

import com.fasterxml.classmate.TypeResolver;
import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;

import springfox.documentation.RequestHandler;
import springfox.documentation.builders.AlternateTypeBuilder;
import springfox.documentation.builders.AlternateTypePropertyBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.AlternateTypeRule;
import springfox.documentation.schema.AlternateTypeRuleConvention;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.lang.reflect.Type;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2
public class SwaggerConfig {
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2)
			.select()
			.apis(controllers())
			.paths(PathSelectors.any())
			.build();
	}

	private static Predicate<RequestHandler> controllers() {
		return RequestHandlerSelectors
			.basePackage("br.com.iteris.cpfReader.controller");
	}


		private AlternateTypePropertyBuilder property(Class<?> type, String name) {
			return new AlternateTypePropertyBuilder()
					.withName(name)
					.withType(type)
					.withCanRead(true)
					.withCanWrite(true);
		}

}

package br.com.iteris.cpfReader.configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Data
@Order(Ordered.HIGHEST_PRECEDENCE)
@ConfigurationProperties("csv")
public class CadastroCandidatoCsvConfiguration {
    private String path;
}

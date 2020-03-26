package br.com.iteris.cpfReader.configuration;

import br.com.iteris.cpfReader.util.CadastroCandidatoReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CsvConfiguration {
    final Logger LOGGER = LoggerFactory.getLogger(CsvConfiguration.class);

    @Bean
    public CommandLineRunner run(ApplicationContext context) {
        return args -> this.configureCvs(context, args);
    }

    private void configureCvs(ApplicationContext context, String[] args) {
        CadastroCandidatoReader cadastroCandidatoReader = context.getBean(CadastroCandidatoReader.class);
        CadastroCandidatoCsvConfiguration cadastroCandidatoCsvConfiguration =  context.getBean(CadastroCandidatoCsvConfiguration.class);

        String path = this.getCsvPathByParam(args);

        if(path.isEmpty()) {
            path = cadastroCandidatoCsvConfiguration.getPath();
        }

        LOGGER.info("######################### Lido o arquivo CSV do caminho: "+path);

        cadastroCandidatoReader.fileLoad(path);
    }

    private String getCsvPathByParam(String[] args) {
        String csvPath = "";
        if(args.length > 0 && args[0].contains("--csv.path")) {
            String[] arguments = args[0].split("=");
            if(arguments.length > 1) {
                csvPath = arguments[1];
            }
        }
        return csvPath;


    }
}

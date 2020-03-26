package br.com.iteris.cpfReader.util;

import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Component
public class CadastroCandidatoReader implements ResourceLoaderAware {
    private static final String COMMA_DELIMITER = ";";
    public static final String READ_TYPE = "file:";
    private List<List<String>> records =  new ArrayList<>();
    ResourceLoader resourceLoader;

    public void fileLoad(String path) {
        Resource resource = resourceLoader.getResource(READ_TYPE + path);
        Scanner scanner = null;
        try {
            scanner = new Scanner(resource.getFile());
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Não encontrado o arquivo "+path);
        }

        scanner.useDelimiter(COMMA_DELIMITER);
        while (scanner.hasNextLine()) {
            records.add(this.getRecordFromLine(scanner.nextLine()));
        }
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(COMMA_DELIMITER);
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    public List<List<String>> getRegistroList() {
        return this.records;
    }

}

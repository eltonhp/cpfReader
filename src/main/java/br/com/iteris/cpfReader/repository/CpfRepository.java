package br.com.iteris.cpfReader.repository;

import br.com.iteris.cpfReader.util.CadastroCandidatoReader;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class CpfRepository  {

    private CadastroCandidatoReader cadastroCandidatoReader;
    private final int CPF_COLUMN = 1;
    private final String CPF_HEADER = "cpf";


    public CpfRepository(CadastroCandidatoReader cadastroCandidatoReader) {
        this.cadastroCandidatoReader = cadastroCandidatoReader;
    }

    private String getCpf(List<String> columnListByLine) {
        return columnListByLine.get(CPF_COLUMN);
    }

    public List<String> getCpfList() {
        return this.cadastroCandidatoReader.getRegistroList()
                   .parallelStream()
                   .map(this::getCpf)
                   .filter(element -> !element.equals(CPF_HEADER))
                   .collect(Collectors.toList());


    }
}

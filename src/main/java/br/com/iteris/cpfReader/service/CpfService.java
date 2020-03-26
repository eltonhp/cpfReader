package br.com.iteris.cpfReader.service;

import br.com.iteris.cpfReader.repository.CpfRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CpfService  {

    private CpfRepository cpfRepository;

    public CpfService(CpfRepository cpfRepository) {
        this.cpfRepository = cpfRepository;
    }

    public List<String> getCpfList() {
        return this.cpfRepository.getCpfList();
    }

}

package br.com.iteris.cpfReader.controller;

import br.com.iteris.cpfReader.service.CpfService;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/api/cpfReader")
public class CpfController {
    @Autowired
    private CpfService cpfService;



    @GetMapping(path = "/cpfs")
    @ApiOperation(value = "Return the cpf list of cadastro-candidato.csv")
    public   ResponseEntity<List<String>>  getCpfList() {
        List<String> response = this.cpfService.getCpfList();
        return ResponseEntity.ok(response);
    }
}

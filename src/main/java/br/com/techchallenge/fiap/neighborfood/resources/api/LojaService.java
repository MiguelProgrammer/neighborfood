package br.com.techchallenge.fiap.neighborfood.resources.api;

import _generated_sources_swagger.AnalystApi;
import br.com.techchallenge.fiap.model.AnalystDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@RestController
public class LojaService implements AnalystApi {


    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<AnalystDTO> addAnalyst(AnalystDTO analystDTO) {
        return AnalystApi.super.addAnalyst(analystDTO);
    }

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<Void> deleteAnalystById(Long pId) {
        return AnalystApi.super.deleteAnalystById(pId);
    }


    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<AnalystDTO> getAllAnalyst() {
        return AnalystApi.super.getAllAnalyst();
    }

    @Override
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<AnalystDTO> getAnalystById(Long pId) {
        return AnalystApi.super.getAnalystById(pId);
    }


    @Override
    @CrossOrigin(origins = "*")
    public ResponseEntity<AnalystDTO> updateAnalyst(AnalystDTO analystDTO) {
        return AnalystApi.super.updateAnalyst(analystDTO);
    }
}

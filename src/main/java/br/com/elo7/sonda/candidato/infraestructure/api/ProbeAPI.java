package br.com.elo7.sonda.candidato.infraestructure.api;

import br.com.elo7.sonda.candidato.application.probe.retrieve.list.ProbeListOutput;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.CreateProbeApiInput;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.ProbeApiOutput;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "probe")
public interface ProbeAPI {

    @GetMapping("/{id}")
    ProbeApiOutput getById(@PathVariable int id);

    @GetMapping
    ResponseEntity<List<ProbeListOutput>> findAll();

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    ResponseEntity<?> register(@RequestBody CreateProbeApiInput input);
}

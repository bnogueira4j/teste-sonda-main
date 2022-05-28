package br.com.elo7.sonda.candidato.infraestructure.api;

import br.com.elo7.sonda.candidato.application.planet.common.PlanetOutput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.CreatePlanetApiInput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.PlanetApiOutput;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@RequestMapping(value = "planet")
public interface PlanetAPI {

    @GetMapping("/{id}")
    public PlanetApiOutput getById(@PathVariable int id);

    @GetMapping
    public ResponseEntity<List<PlanetOutput>> findAll();

    @PostMapping(
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public ResponseEntity<?> register(@RequestBody CreatePlanetApiInput input);
}

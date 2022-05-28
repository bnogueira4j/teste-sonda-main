package br.com.elo7.sonda.candidato.infraestructure.api.controller;

import br.com.elo7.sonda.candidato.application.planet.common.PlanetOutput;
import br.com.elo7.sonda.candidato.application.planet.create.CreatePlanetCommand;
import br.com.elo7.sonda.candidato.application.planet.create.CreatePlanetUseCase;
import br.com.elo7.sonda.candidato.application.planet.retrieve.get.GetPlanetByIdUseCase;
import br.com.elo7.sonda.candidato.application.planet.retrieve.list.ListPlanetsUseCase;
import br.com.elo7.sonda.candidato.infraestructure.api.PlanetAPI;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.CreatePlanetApiInput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.PlanetApiOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class PlanetController implements PlanetAPI {

    private CreatePlanetUseCase createPlanetUseCase;
    private ListPlanetsUseCase listPlanetsUseCase;
    private GetPlanetByIdUseCase getPlanetByIdUseCase;

    public PlanetController(CreatePlanetUseCase createPlanetUseCase, ListPlanetsUseCase listPlanetsUseCase, GetPlanetByIdUseCase getPlanetByIdUseCase) {
        this.createPlanetUseCase = createPlanetUseCase;
        this.listPlanetsUseCase = listPlanetsUseCase;
        this.getPlanetByIdUseCase = getPlanetByIdUseCase;
    }

    @GetMapping("/{id}")
    public PlanetApiOutput getById(@PathVariable final int id) {
        return PlanetApiOutput.from(getPlanetByIdUseCase.execute(id));
    }

    @GetMapping
    public ResponseEntity<List<PlanetOutput>> findAll() {
        return ResponseEntity.ok(listPlanetsUseCase.execute());
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody final CreatePlanetApiInput input) {
        final var command = CreatePlanetCommand.with(input.width(), input.height());
        final var output = createPlanetUseCase.execute(command);
        return ResponseEntity.created(URI.create("/planet/" + output.id())).body(output.id());
    }
}

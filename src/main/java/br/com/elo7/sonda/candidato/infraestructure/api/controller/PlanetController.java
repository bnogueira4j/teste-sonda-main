package br.com.elo7.sonda.candidato.infraestructure.api.controller;

import br.com.elo7.sonda.candidato.application.planet.create.CreatePlanetCommand;
import br.com.elo7.sonda.candidato.application.planet.create.CreatePlanetUseCase;
import br.com.elo7.sonda.candidato.application.planet.retrieve.get.GetPlanetByIdUseCase;
import br.com.elo7.sonda.candidato.application.planet.retrieve.list.ListPlanetsUseCase;
import br.com.elo7.sonda.candidato.application.planet.update.UpdatePlanetCommand;
import br.com.elo7.sonda.candidato.application.planet.update.UpdatePlanetUseCase;
import br.com.elo7.sonda.candidato.infraestructure.api.PlanetAPI;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.CreatePlanetApiInput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.PlanetApiInput;
import br.com.elo7.sonda.candidato.infraestructure.planet.models.PlanetApiOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class PlanetController implements PlanetAPI {

    private CreatePlanetUseCase createPlanetUseCase;
    private ListPlanetsUseCase listPlanetsUseCase;
    private GetPlanetByIdUseCase getPlanetByIdUseCase;
    private UpdatePlanetUseCase updatePlanetUseCase;

    public PlanetController(
            CreatePlanetUseCase createPlanetUseCase,
            ListPlanetsUseCase listPlanetsUseCase,
            GetPlanetByIdUseCase getPlanetByIdUseCase,
            UpdatePlanetUseCase updatePlanetUseCase) {
        this.createPlanetUseCase = createPlanetUseCase;
        this.listPlanetsUseCase = listPlanetsUseCase;
        this.getPlanetByIdUseCase = getPlanetByIdUseCase;
        this.updatePlanetUseCase = updatePlanetUseCase;
    }

    @Override
    public PlanetApiOutput getById(@PathVariable final int id) {
        return PlanetApiOutput.from(getPlanetByIdUseCase.execute(id));
    }

    @Override
    public List<?> findAll() {
        return listPlanetsUseCase.execute().stream().map(PlanetApiOutput::from).toList();
    }

    @Override
    public ResponseEntity<?> register(@RequestBody final CreatePlanetApiInput input) {
        final var command = CreatePlanetCommand.with(input.width(), input.height());
        final var output = createPlanetUseCase.execute(command);
        return ResponseEntity.created(URI.create("/planet/" + output.id())).body(output.id());
    }

    @Override
    public ResponseEntity<?> update(PlanetApiInput input) {
        final var command = UpdatePlanetCommand.with(input.id(), input.width(), input.height());
        return ResponseEntity.ok(PlanetApiOutput.from(updatePlanetUseCase.execute(command)));
    }
}

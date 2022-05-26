package br.com.elo7.sonda.candidato.infraestructure.api.controller;

import br.com.elo7.sonda.candidato.application.probe.create.CreateProbeCommand;
import br.com.elo7.sonda.candidato.application.probe.create.CreateProbeUseCase;
import br.com.elo7.sonda.candidato.application.probe.retrieve.get.GetProbeByIdUseCase;
import br.com.elo7.sonda.candidato.application.probe.retrieve.list.ListProbesUseCase;
import br.com.elo7.sonda.candidato.application.probe.retrieve.list.ProbeListOutput;
import br.com.elo7.sonda.candidato.infraestructure.api.ProbeAPI;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.CreateProbeApiInput;
import br.com.elo7.sonda.candidato.infraestructure.probe.models.ProbeApiOutput;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
public class ProbeController implements ProbeAPI {

    private CreateProbeUseCase createProbeUseCase;
    private ListProbesUseCase listProbesUseCase;
    private GetProbeByIdUseCase getProbeByIdUseCase;

    public ProbeController(final CreateProbeUseCase createProbeUseCase, final ListProbesUseCase listProbesUseCase, final GetProbeByIdUseCase getProbeByIdUseCase) {
        this.createProbeUseCase = createProbeUseCase;
        this.listProbesUseCase = listProbesUseCase;
        this.getProbeByIdUseCase = getProbeByIdUseCase;
    }

    @GetMapping("/{id}")
    public ProbeApiOutput getById(@PathVariable final int id) {
        return ProbeApiOutput.from(getProbeByIdUseCase.execute(id));
    }

    @GetMapping
    public ResponseEntity<List<ProbeListOutput>> findAll() {
        return ResponseEntity.ok(listProbesUseCase.execute());
    }

    @PostMapping
    public ResponseEntity<?> register(@RequestBody final CreateProbeApiInput input) {
        final var command = CreateProbeCommand.with(input.positionX(), input.positionY(), input.direction(), input.commands(), input.planetId());
        final var output = createProbeUseCase.execute(command);
        return ResponseEntity.created(URI.create("/planet/" + output.id())).body(output.id());
    }
}

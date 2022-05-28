package br.com.elo7.sonda.candidato.application.probe.create;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.application.probe.move.MoveProbeCommand;
import br.com.elo7.sonda.candidato.application.probe.move.MoveProbeUseCase;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DefaultCreateProbeUseCase extends CreateProbeUseCase {

    private final ProbeGateway gateway;
    private final PlanetGateway planetGateway;
    private final MoveProbeUseCase moveProbeUseCase;

    public DefaultCreateProbeUseCase(final ProbeGateway gateway, final PlanetGateway planetGateway, MoveProbeUseCase moveProbeUseCase) {
        this.gateway = Objects.requireNonNull(gateway);
        this.planetGateway = planetGateway;
        this.moveProbeUseCase = moveProbeUseCase;
    }

    @Override
    public CreateProbeOutput execute(final CreateProbeCommand command) {
        final var planet = planetGateway.findById(command.planetId())
                .orElseThrow(() ->
                        new NotFoundException("Planet with ID %s was not found".formatted(command.planetId())));

        final var probe = Probe.newProbe(command.positionX(), command.positionY(), command.direction(), planet);

        moveProbeUseCase.execute(MoveProbeCommand.with(probe, command.moveCommands()));
        return CreateProbeOutput.from(this.gateway.create(probe));
    }
}

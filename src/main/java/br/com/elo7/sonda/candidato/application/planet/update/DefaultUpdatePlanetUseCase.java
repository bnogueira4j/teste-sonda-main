package br.com.elo7.sonda.candidato.application.planet.update;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.application.planet.common.PlanetOutput;
import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DefaultUpdatePlanetUseCase extends UpdatePlanetUseCase {

    private final PlanetGateway gateway;

    public DefaultUpdatePlanetUseCase(PlanetGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public PlanetOutput execute(final UpdatePlanetCommand command) {
        final var planet = gateway.findById(command.id())
                .orElseThrow(() ->
                        new NotFoundException("Planet with ID %s was not found".formatted(command.id())));
        planet.update(command.width(), command.height()).validate();
        return PlanetOutput.from(this.gateway.update(planet));
    }
}

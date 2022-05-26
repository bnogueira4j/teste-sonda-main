package br.com.elo7.sonda.candidato.application.planet.create;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DefaultCreatePlanetUseCase extends CreatePlanetUseCase {

    private final PlanetGateway gateway;

    public DefaultCreatePlanetUseCase(PlanetGateway gateway) {
        this.gateway = Objects.requireNonNull(gateway);
    }

    @Override
    public CreatePlanetOutput execute(final CreatePlanetCommand command) {
        final var planet = Planet.newPlanet(command.width(), command.height());
        planet.validate();
        return CreatePlanetOutput.from(this.gateway.create(planet));
    }
}

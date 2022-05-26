package br.com.elo7.sonda.candidato.application.planet.retrieve.get;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.domain.exceptions.DomainException;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
public class DefaultGetPlanetByIdUseCase extends GetPlanetByIdUseCase {

    private final PlanetGateway gateway;

    public DefaultGetPlanetByIdUseCase(final PlanetGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public PlanetOutput execute(Integer id) {
        return gateway.findById(id)
                .map(PlanetOutput::from)
                .orElseThrow(() -> new NotFoundException("Planet with ID %s was not found".formatted(id)));
    }
}

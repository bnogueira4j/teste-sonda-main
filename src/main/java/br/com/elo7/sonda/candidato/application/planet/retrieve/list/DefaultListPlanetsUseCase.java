package br.com.elo7.sonda.candidato.application.planet.retrieve.list;

import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultListPlanetsUseCase extends ListPlanetsUseCase {

    private final PlanetGateway gateway;

    public DefaultListPlanetsUseCase(final PlanetGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public List<PlanetListOutput> execute() {
        return gateway.findAll().stream().map(PlanetListOutput::from).toList();
    }
}

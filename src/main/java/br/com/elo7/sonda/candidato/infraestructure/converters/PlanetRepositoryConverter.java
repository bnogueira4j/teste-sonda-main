package br.com.elo7.sonda.candidato.infraestructure.converters;

import br.com.elo7.sonda.candidato.core.domain.Planet;
import br.com.elo7.sonda.candidato.infraestructure.entities.PlanetEntity;
import org.springframework.stereotype.Component;

@Component
public class PlanetRepositoryConverter {

    public PlanetEntity mapToTable(final Planet persistenceObject) {
        return new PlanetEntity(persistenceObject.getId(), persistenceObject.getWidth(), persistenceObject.getHeight());
    }

    public Planet mapToEntity(final PlanetEntity entityObject) {
        return new Planet(entityObject.getId(), entityObject.getWidth(), entityObject.getHeight());
    }
}

package br.com.elo7.sonda.candidato.infraestructure.converters;

import br.com.elo7.sonda.candidato.core.domain.Planet;
import br.com.elo7.sonda.candidato.core.domain.Probe;
import br.com.elo7.sonda.candidato.infraestructure.entities.PlanetEntity;
import br.com.elo7.sonda.candidato.infraestructure.entities.ProbeEntity;
import org.springframework.stereotype.Component;

@Component
public class ProbeRepositoryConverter {

    public ProbeEntity mapToTable(final Probe persistenceObject) {
        return new ProbeEntity(
                persistenceObject.getId(),
                persistenceObject.getPositionX(),
                persistenceObject.getPositionY(),
                persistenceObject.getDirection(),
                new PlanetEntity(
                        persistenceObject.getPlanet().getId(),
                        persistenceObject.getPlanet().getWidth(),
                        persistenceObject.getPlanet().getHeight()
                )
        );
    }

    public Probe mapToEntity(final ProbeEntity entityObject) {
        return new Probe(
                entityObject.getId(),
                entityObject.getPositionX(),
                entityObject.getPositionY(),
                entityObject.getDirection(),
                new Planet(
                        entityObject.getPlanet().getId(),
                        entityObject.getPlanet().getWidth(),
                        entityObject.getPlanet().getHeight()
                )
        );
    }
}

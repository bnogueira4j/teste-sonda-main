package br.com.elo7.sonda.candidato.infraestructure.postgresql;

import br.com.elo7.sonda.candidato.core.domain.Planet;
import br.com.elo7.sonda.candidato.core.repository.IPlanetRepository;
import br.com.elo7.sonda.candidato.infraestructure.converters.PlanetRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class PlanetRepositoryImpl implements IPlanetRepository {

    private SpringDataPlanetRepository springRepository;
    private PlanetRepositoryConverter planetConverter;

    @Autowired
    public PlanetRepositoryImpl(SpringDataPlanetRepository springRepository, PlanetRepositoryConverter planetConverter) {
        this.springRepository = springRepository;
        this.planetConverter = planetConverter;
    }

    @Override
    public Planet save(final Planet planet) {
        final var planetEntity = planetConverter.mapToTable(planet);
        return planetConverter.mapToEntity(springRepository.save(planetEntity));
    }

    @Override
    public Optional<Planet> findById(final int id) {
        final var planet = springRepository.findById(id);
        return planet.map(planetConverter::mapToEntity);
    }

//    @Override
//    public Iterable<Planet> findAll() {
//        final var planetList = springRepository.findAll();
//        return planetList.iterator();
//    }
}

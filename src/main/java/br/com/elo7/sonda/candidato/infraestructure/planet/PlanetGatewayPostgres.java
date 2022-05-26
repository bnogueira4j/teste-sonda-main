package br.com.elo7.sonda.candidato.infraestructure.planet;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import br.com.elo7.sonda.candidato.infraestructure.planet.persistence.PlanetEntity;
import br.com.elo7.sonda.candidato.infraestructure.planet.persistence.PlanetRepository;
import br.com.elo7.sonda.candidato.infraestructure.probe.persistence.ProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PlanetGatewayPostgres implements PlanetGateway {

    private PlanetRepository repository;
    private ProbeRepository probeRepository;

    @Autowired
    public PlanetGatewayPostgres(PlanetRepository repository, ProbeRepository probeRepository) {
        this.repository = repository;
        this.probeRepository = probeRepository;
    }

    @Override
    public List<Planet> findAll() {
        return repository.findAll().stream().map(PlanetEntity::toAggregate).toList();
    }

    @Override
    public Optional<Planet> findById(int id) {
        return repository.findById(id).map(PlanetEntity::toAggregate);
    }

    @Override
    public Planet create(final Planet planet) {
        return repository.save(PlanetEntity.from(planet)).toAggregate();
    }
}

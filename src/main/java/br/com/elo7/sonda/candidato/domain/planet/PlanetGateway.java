package br.com.elo7.sonda.candidato.domain.planet;

import java.util.List;
import java.util.Optional;

public interface PlanetGateway {

    List<Planet> findAll();

    Optional<Planet> findById(int id);

    Planet create(Planet planet);

    Planet update(Planet planet);
}

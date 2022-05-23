package br.com.elo7.sonda.candidato.core.repository;

import br.com.elo7.sonda.candidato.core.domain.Planet;

import java.util.Optional;

public interface IPlanetRepository {

    Planet save(Planet planet);

    Optional<Planet> findById(int id);

//    Iterable<Planet> findAll();
}

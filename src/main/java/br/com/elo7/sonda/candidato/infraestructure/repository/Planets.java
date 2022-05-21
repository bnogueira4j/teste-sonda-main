package br.com.elo7.sonda.candidato.infraestructure.repository;

import java.util.Optional;

import br.com.elo7.sonda.candidato.core.domain.Planet;

public interface Planets {

	void save(Planet planet);

	Optional<Planet> findById(int id);

}

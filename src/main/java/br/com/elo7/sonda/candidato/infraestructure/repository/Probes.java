package br.com.elo7.sonda.candidato.infraestructure.repository;

import java.util.Optional;

import br.com.elo7.sonda.candidato.core.domain.Probe;

public interface Probes {

	void save(Probe probe);

	Optional<Probe> findById(int id);

}

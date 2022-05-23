package br.com.elo7.sonda.candidato.core.repository;

import br.com.elo7.sonda.candidato.core.domain.Probe;

import java.util.List;
import java.util.Optional;

public interface IProbeRepository {

    Probe save(Probe probe);

    Optional<Probe> findById(int id);

//    Iterable<Probe> findAll();
}

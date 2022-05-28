package br.com.elo7.sonda.candidato.domain.probe;

import java.util.List;
import java.util.Optional;

public interface ProbeGateway {

    List<Probe> findAll();
    Optional<Probe> findById(int id);
    Probe create(Probe probe);
    Probe update(Probe probe);
}

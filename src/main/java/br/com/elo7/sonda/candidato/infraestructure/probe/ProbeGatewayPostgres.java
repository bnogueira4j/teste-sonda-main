package br.com.elo7.sonda.candidato.infraestructure.probe;

import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import br.com.elo7.sonda.candidato.infraestructure.probe.persistence.ProbeEntity;
import br.com.elo7.sonda.candidato.infraestructure.probe.persistence.ProbeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProbeGatewayPostgres implements ProbeGateway {

    private ProbeRepository repository;

    @Autowired
    public ProbeGatewayPostgres(ProbeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Probe> findAll() {
        return repository.findAll().stream().map(ProbeEntity::toAggregate).toList();
    }

    @Override
    public Optional<Probe> findById(int id) {
        return repository.findById(id).map(ProbeEntity::toAggregate);
    }

    @Override
    public Probe create(final Probe probe) {
        return repository.save(ProbeEntity.from(probe)).toAggregate();
    }

    @Override
    public Probe update(Probe probe) {
        return repository.save(ProbeEntity.from(probe)).toAggregate();
    }
}

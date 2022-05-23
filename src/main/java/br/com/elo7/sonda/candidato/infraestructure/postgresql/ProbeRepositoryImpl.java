package br.com.elo7.sonda.candidato.infraestructure.postgresql;

import br.com.elo7.sonda.candidato.core.domain.Probe;
import br.com.elo7.sonda.candidato.core.repository.IProbeRepository;
import br.com.elo7.sonda.candidato.infraestructure.converters.ProbeRepositoryConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class ProbeRepositoryImpl implements IProbeRepository {

    private SpringDataProbeRepository springRepository;
    private ProbeRepositoryConverter probeConverter;

    @Autowired
    public ProbeRepositoryImpl(SpringDataProbeRepository springRepository, ProbeRepositoryConverter probeConverter) {
        this.springRepository = springRepository;
        this.probeConverter = probeConverter;
    }

    @Override
    public Probe save(final Probe probe) {
        final var probeEntity = probeConverter.mapToTable(probe);
        return probeConverter.mapToEntity(springRepository.save(probeEntity));
    }

    @Override
    public Optional<Probe> findById(int id) {
        final var probe = springRepository.findById(id);
        return probe.map(probeConverter::mapToEntity);
    }

//    @Override
//    public Iterable<Probe> findAll() {
//        return springRepository.findAll();
//    }
}

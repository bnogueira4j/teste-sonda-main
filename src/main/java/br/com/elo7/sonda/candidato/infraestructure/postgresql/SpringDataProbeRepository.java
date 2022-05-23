package br.com.elo7.sonda.candidato.infraestructure.postgresql;

import br.com.elo7.sonda.candidato.infraestructure.entities.ProbeEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpringDataProbeRepository extends PagingAndSortingRepository<ProbeEntity, Integer> {

}

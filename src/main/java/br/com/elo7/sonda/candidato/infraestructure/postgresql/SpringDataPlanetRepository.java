package br.com.elo7.sonda.candidato.infraestructure.postgresql;

import br.com.elo7.sonda.candidato.infraestructure.entities.PlanetEntity;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface SpringDataPlanetRepository extends PagingAndSortingRepository<PlanetEntity, Integer> {

}

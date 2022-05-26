package br.com.elo7.sonda.candidato.infraestructure.planet.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends JpaRepository<PlanetEntity, Integer> {

}

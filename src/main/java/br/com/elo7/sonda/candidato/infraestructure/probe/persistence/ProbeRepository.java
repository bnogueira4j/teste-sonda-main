package br.com.elo7.sonda.candidato.infraestructure.probe.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProbeRepository extends JpaRepository<ProbeEntity, Integer> {

}

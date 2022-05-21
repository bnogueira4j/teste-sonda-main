package br.com.elo7.sonda.candidato.core.gateways;

import br.com.elo7.sonda.candidato.application.dto.InputDTO;
import br.com.elo7.sonda.candidato.core.domain.Probe;

import java.util.List;

public interface AbstractProbeGateway {
    List<Probe> landProbes(InputDTO input);
}

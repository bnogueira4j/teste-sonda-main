package br.com.elo7.sonda.candidato.infraestructure.probe.models;

import br.com.elo7.sonda.candidato.application.probe.common.ProbeOutput;
import br.com.elo7.sonda.candidato.domain.probe.Direction;

public record ProbeApiOutput(int id,
                             int positionX,
                             int positionY,
                             Direction direction,
                             int planetId) {

    public static ProbeApiOutput from(final ProbeOutput output) {
        return new ProbeApiOutput(output.id(), output.positionX(), output.positionY(), output.direction(), output.planetId());
    }
}

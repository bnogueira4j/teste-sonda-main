package br.com.elo7.sonda.candidato.application.probe.common;

import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;

public record ProbeOutput(
        int id,
        int positionX,
        int positionY,
        Direction direction,
        int planetId
) {
    public static ProbeOutput from(final Probe probe) {
        return new ProbeOutput(probe.getId(), probe.getPositionX(), probe.getPositionY(), probe.getDirection(), probe.getPlanet().getId());
    }
}

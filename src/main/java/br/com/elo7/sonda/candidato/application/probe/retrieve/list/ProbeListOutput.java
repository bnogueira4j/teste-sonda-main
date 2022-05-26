package br.com.elo7.sonda.candidato.application.probe.retrieve.list;

import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;

public record ProbeListOutput(
        int id,
        int positionX,
        int positionY,
        Direction direction,
        int planetId
) {
    public static ProbeListOutput from(final Probe probe) {
        return new ProbeListOutput(probe.getId(), probe.getPositionX(), probe.getPositionY(), probe.getDirection(), probe.getPlanet().getId());
    }
}

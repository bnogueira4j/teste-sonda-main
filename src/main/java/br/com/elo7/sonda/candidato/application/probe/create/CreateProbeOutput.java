package br.com.elo7.sonda.candidato.application.probe.create;

import br.com.elo7.sonda.candidato.domain.probe.Probe;

public record CreateProbeOutput(
        int id
) {
    public static CreateProbeOutput from(
            final Probe probe
    ) {
        return new CreateProbeOutput(probe.getId());
    }
}

package br.com.elo7.sonda.candidato.application.probe.move;

import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Probe;

import java.util.List;

public record MoveProbeCommand(
        Probe probe,
        List<Command> moveCommands
) {
    public static MoveProbeCommand with(
            final Probe probe,
            final List<Command> commands) {
        return new MoveProbeCommand(probe, commands);
    }
}

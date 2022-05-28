package br.com.elo7.sonda.candidato.application.probe.control;

import br.com.elo7.sonda.candidato.domain.probe.Command;

import java.util.List;

public record ControlProbeCommand(
        int id,
        List<Command> moveCommands
) {
    public static ControlProbeCommand with(
            final int id,
            final List<Command> commands) {
        return new ControlProbeCommand(id, commands);
    }
}

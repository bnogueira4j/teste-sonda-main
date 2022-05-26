package br.com.elo7.sonda.candidato.application.probe.create;

import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Direction;

import java.util.List;

public record CreateProbeCommand(
         int positionX,
         int positionY,
         Direction direction,
         List<Command> moveCommands,
         int planetId
) {
    public static CreateProbeCommand with(
            final int positionX,
            final int positionY,
            final Direction direction,
            final List<Command> commands,
            final int planetId
    ) {
        return new CreateProbeCommand(positionX, positionY, direction, commands, planetId);
    }
}

package br.com.elo7.sonda.candidato.application.probe.move;

import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import org.springframework.stereotype.Component;

@Component
public class DefaultMoveProbeUseCase extends MoveProbeUseCase {

    @Override
    public Probe execute(final MoveProbeCommand command) {
        command.moveCommands().forEach(move -> applyCommandToProbe(command.probe(), move));
        return command.probe();
    }

    private void applyCommandToProbe(final Probe probe, final Command command) {
        switch (command) {
            case RIGHT -> probe.turnRight();
            case LEFT -> probe.turnLeft();
            case MOVE -> probe.moveForward();
        }
    }


}

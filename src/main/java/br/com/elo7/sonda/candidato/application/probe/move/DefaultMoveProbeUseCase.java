package br.com.elo7.sonda.candidato.application.probe.move;

import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.stereotype.Component;

@Component
public class DefaultMoveProbeUseCase extends MoveProbeUseCase {

    @Override
    public Probe execute(final MoveProbeCommand command) {
        command.moveCommands().forEach(move -> applyCommandToProbe(command.probe(), move));
        return command.probe();
    }

    @VisibleForTesting
    void applyCommandToProbe(final Probe probe, final Command command) {
        switch (command) {
            case RIGHT -> turnProbeRight(probe);
            case LEFT -> turnProbeLeft(probe);
            case MOVE -> moveProbeForward(probe);
        }
    }

    private void moveProbeForward(Probe probe) {
        int newPositionX = probe.getPositionX();
        int newPositionY = probe.getPositionY();
        switch (probe.getDirection()) {
            case NORTH -> newPositionY++;
            case WEST -> newPositionX--;
            case SOUTH -> newPositionY--;
            case EAST -> newPositionX++;
        }
        probe.setPositionX(newPositionX);
        probe.setPositionY(newPositionY);
    }

    private void turnProbeLeft(Probe probe) {
        Direction newDirection = switch (probe.getDirection()) {
            case NORTH -> Direction.WEST;
            case WEST -> Direction.SOUTH;
            case SOUTH -> Direction.EAST;
            case EAST -> Direction.NORTH;
        };
        probe.setDirection(newDirection);
    }

    private void turnProbeRight(Probe probe) {
        Direction newDirection = switch (probe.getDirection()) {
            case NORTH -> Direction.EAST;
            case EAST -> Direction.SOUTH;
            case SOUTH -> Direction.WEST;
            case WEST -> Direction.NORTH;
        };
        System.out.println(newDirection);
        probe.setDirection(newDirection);
    }
}

package br.com.elo7.sonda.candidato.application.probe.create;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import com.google.common.annotations.VisibleForTesting;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class DefaultCreateProbeUseCase extends CreateProbeUseCase {

    private final ProbeGateway gateway;
    private final PlanetGateway planetGateway;

    public DefaultCreateProbeUseCase(final ProbeGateway gateway, final PlanetGateway planetGateway) {
        this.gateway = Objects.requireNonNull(gateway);
        this.planetGateway = planetGateway;
    }

    @Override
    public CreateProbeOutput execute(final CreateProbeCommand command) {
        final var planet = planetGateway.findById(command.planetId())
                .orElseThrow(() ->
                        new NotFoundException("Planet with ID %s was not found".formatted(command.planetId())));

        final var probe = Probe.newProbe(command.positionX(), command.positionY(), command.direction(), planet);
        command.moveCommands().forEach(move -> applyCommandToProbe(probe, move));
        return CreateProbeOutput.from(this.gateway.create(probe));
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

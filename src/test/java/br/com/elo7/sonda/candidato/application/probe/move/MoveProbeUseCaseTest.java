package br.com.elo7.sonda.candidato.application.probe.move;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class MoveProbeUseCaseTest {

    @InjectMocks
    private DefaultMoveProbeUseCase useCase;

    @Test
    public void givenAValidCommand_withEmptyMovement_whenCallsMoveProbeNorthDirection_shouldReturnProbeNorthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, expectedDirection, expectedPlanet.get());
        final var movementCommand = Collections.<Command>emptyList();
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsMoveProbeNorthDirection_shouldReturnProbeWestDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.WEST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.NORTH, expectedPlanet.get());
        final var movementCommand = List.of(Command.LEFT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsMoveProbeWestDirection_shouldReturnProbeSouthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.SOUTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.WEST, expectedPlanet.get());
        final var movementCommand = List.of(Command.LEFT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsMoveProbeSouthDirection_shouldReturnProbeEastDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.EAST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.SOUTH, expectedPlanet.get());
        final var movementCommand = List.of(Command.LEFT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsMoveProbeEasDirection_shouldReturnProbeNorthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.EAST, expectedPlanet.get());
        final var movementCommand = List.of(Command.LEFT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsMoveProbeNorthDirection_shouldReturnProbeEastDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.EAST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.NORTH, expectedPlanet.get());
        final var movementCommand = List.of(Command.RIGHT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsMoveProbeEastDirection_shouldReturnProbeSouthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.SOUTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.EAST, expectedPlanet.get());
        final var movementCommand = List.of(Command.RIGHT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsMoveProbeSouthDirection_shouldReturnProbeWestDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.WEST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.SOUTH, expectedPlanet.get());
        final var movementCommand = List.of(Command.RIGHT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsMoveProbeWestDirection_shouldReturnProbeNorthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(expectedPositionX, expectedPositionY, Direction.WEST, expectedPlanet.get());
        final var movementCommand = List.of(Command.RIGHT);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndNorthDirection_whenCallsMoveProbePositionX1AndPositionY1_shouldReturnProbePositionX1AndPositionY2() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 2;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(1, 1, expectedDirection, expectedPlanet.get());
        final var movementCommand = List.of(Command.MOVE);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndSouthDirection_whenCallsMoveProbePositionX1AndPositionY1_shouldReturnProbePositionX1AndPositionY0() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 0;
        final var expectedDirection = Direction.SOUTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(1, 1, expectedDirection, expectedPlanet.get());
        final var movementCommand = List.of(Command.MOVE);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndWestDirection_whenCallsMoveProbePositionX1AndPositionY1_shouldReturnProbePositionX0AndPositionY1() {
        final var expectedPositionX = 0;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.WEST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(1, 1, expectedDirection, expectedPlanet.get());
        final var movementCommand = List.of(Command.MOVE);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndEastDirection_whenCallsMoveProbePositionX1AndPositionY1_shouldReturnProbePositionX2AndPositionY1() {
        final var expectedPositionX = 2;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.EAST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var probeCommand = Probe.newProbe(1, 1, expectedDirection, expectedPlanet.get());
        final var movementCommand = List.of(Command.MOVE);
        final var command = MoveProbeCommand.with(probeCommand, movementCommand);

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPositionX, actualOutput.getPositionX());
        Assertions.assertEquals(expectedPositionY, actualOutput.getPositionY());
        Assertions.assertEquals(expectedDirection, actualOutput.getDirection());
        Assertions.assertEquals(expectedPlanet.get().getId(), actualOutput.getPlanet().getId());
    }
}

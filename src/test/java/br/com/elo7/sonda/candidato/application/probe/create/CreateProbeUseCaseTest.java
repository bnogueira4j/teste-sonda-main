package br.com.elo7.sonda.candidato.application.probe.create;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import br.com.elo7.sonda.candidato.domain.probe.Command;
import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CreateProbeUseCaseTest {

    @InjectMocks
    private DefaultCreateProbeUseCase useCase;

    @Mock
    private ProbeGateway gateway;

    @Mock
    private PlanetGateway planetGateway;

    @Test
    public void givenAValidCommand_withEmptyMovement_whenCallsCreateProbeNorthDirection_shouldReturnProbeNorthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = Collections.<Command> emptyList();
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, expectedDirection, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsCreateProbeNorthDirection_shouldReturnProbeWestDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.WEST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.LEFT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.NORTH, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsCreateProbeWestDirection_shouldReturnProbeSouthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.SOUTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.LEFT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.WEST, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsCreateProbeSouthDirection_shouldReturnProbeEastDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.EAST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.LEFT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.SOUTH, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withLeftMovement_whenCallsCreateProbeEasDirection_shouldReturnProbeNorthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.LEFT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.EAST, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsCreateProbeNorthDirection_shouldReturnProbeEastDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.EAST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.RIGHT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.NORTH, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsCreateProbeEastDirection_shouldReturnProbeSouthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.SOUTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.RIGHT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.EAST, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsCreateProbeSouthDirection_shouldReturnProbeWestDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.WEST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.RIGHT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.SOUTH, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withRightMovement_whenCallsCreateProbeWestDirection_shouldReturnProbeNorthDirection() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.RIGHT);
        final var command = CreateProbeCommand.with(expectedPositionX, expectedPositionY, Direction.WEST, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndNorthDirection_whenCallsCreateProbePositionX1AndPositionY1_shouldReturnProbePositionX1AndPositionY2() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 2;
        final var expectedDirection = Direction.NORTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.MOVE);
        final var command = CreateProbeCommand.with(1, 1, expectedDirection, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndSouthDirection_whenCallsCreateProbePositionX1AndPositionY1_shouldReturnProbePositionX1AndPositionY0() {
        final var expectedPositionX = 1;
        final var expectedPositionY = 0;
        final var expectedDirection = Direction.SOUTH;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.MOVE);
        final var command = CreateProbeCommand.with(1, 1, expectedDirection, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndWestDirection_whenCallsCreateProbePositionX1AndPositionY1_shouldReturnProbePositionX0AndPositionY1() {
        final var expectedPositionX = 0;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.WEST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.MOVE);
        final var command = CreateProbeCommand.with(1, 1, expectedDirection, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAValidCommand_withMoveMovementAndEastDirection_whenCallsCreateProbePositionX1AndPositionY1_shouldReturnProbePositionX2AndPositionY1() {
        final var expectedPositionX = 2;
        final var expectedPositionY = 1;
        final var expectedDirection = Direction.EAST;
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));

        final var movementCommand = List.of(Command.MOVE);
        final var command = CreateProbeCommand.with(1, 1, expectedDirection, movementCommand, expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(expectedPlanet.get().getId())).thenReturn(expectedPlanet);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);
        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedPositionX, probe.getPositionX())
                                        && Objects.equals(expectedPositionY, probe.getPositionY())
                                        && Objects.equals(expectedDirection, probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }
}

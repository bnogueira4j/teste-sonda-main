package br.com.elo7.sonda.candidato.application.probe.control;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.application.probe.move.MoveProbeUseCase;
import br.com.elo7.sonda.candidato.domain.planet.Planet;
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
import java.util.Objects;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ControlProbeUseCaseTest {

    @InjectMocks
    private DefaultControlProbeUseCase useCase;

    @Mock
    private MoveProbeUseCase moveProbeUseCase;

    @Mock
    private ProbeGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsControlProbe_shouldReturnProbeOutput() {
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));
        final var expectedProbe = Probe.newProbe(1, 1, Direction.NORTH, expectedPlanet.get());

        final var movementCommand = Collections.<Command>emptyList();
        final var command = ControlProbeCommand.with(
                expectedProbe.getId(),
                movementCommand
        );

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.of(expectedProbe));
        Mockito.when(moveProbeUseCase.execute(Mockito.any())).thenReturn(expectedProbe);
        Mockito.when(gateway.update(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);
        Assertions.assertNotNull(actualOutput);

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        probeId ->
                                Objects.equals(expectedProbe.getId(), probeId))
                );

        Mockito.verify(moveProbeUseCase, Mockito.times(1))
                .execute(ArgumentMatchers.argThat(
                        moveCommand ->
                                Objects.equals(expectedProbe.getId(), moveCommand.probe().getId())
                                        && Objects.equals(expectedProbe.getPositionX(), moveCommand.probe().getPositionX())
                                        && Objects.equals(expectedProbe.getPositionY(), moveCommand.probe().getPositionY())
                                        && Objects.equals(command.moveCommands(), moveCommand.moveCommands())
                ));

        Mockito.verify(gateway, Mockito.times(1))
                .update(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedProbe.getPositionX(), probe.getPositionX())
                                        && Objects.equals(expectedProbe.getPositionY(), probe.getPositionY())
                                        && Objects.equals(expectedProbe.getDirection(), probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAInvalidCommandProbeId_whenCallsControlProbe_shouldReturnNotFoundException() {
        final var expectedErrorMessage = "Probe with ID 0 was not found";

        final var probeIdCommand = 0;
        final var movementCommand = Collections.<Command>emptyList();
        final var command = ControlProbeCommand.with(
                probeIdCommand,
                movementCommand
        );

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        final var actualException = Assertions.assertThrows(NotFoundException.class, () -> useCase.execute(command));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
        Mockito.verify(gateway, Mockito.times(1)).findById(Mockito.anyInt());
        Mockito.verify(moveProbeUseCase, Mockito.times(0)).execute(Mockito.any());
        Mockito.verify(gateway, Mockito.times(0)).update(Mockito.any());
    }
}

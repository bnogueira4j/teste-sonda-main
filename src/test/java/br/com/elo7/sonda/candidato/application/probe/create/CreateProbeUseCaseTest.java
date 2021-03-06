package br.com.elo7.sonda.candidato.application.probe.create;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.application.probe.move.MoveProbeUseCase;
import br.com.elo7.sonda.candidato.domain.exceptions.DomainException;
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
import java.util.Objects;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class CreateProbeUseCaseTest {

    @InjectMocks
    private DefaultCreateProbeUseCase useCase;

    @Mock
    private MoveProbeUseCase moveProbeUseCase;

    @Mock
    private ProbeGateway gateway;

    @Mock
    private PlanetGateway planetGateway;

    @Test
    public void givenAValidCommand_whenCallsCreateProbe_shouldReturnProbeOutput() {
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));
        final var expectedProbe = Probe.newProbe(1, 1, Direction.NORTH, expectedPlanet.get());

        final var movementCommand = Collections.<Command>emptyList();
        final var command = CreateProbeCommand.with(
                expectedProbe.getPositionX(),
                expectedProbe.getPositionY(),
                expectedProbe.getDirection(),
                movementCommand,
                expectedPlanet.get().getId());

        Mockito.when(planetGateway.findById(Mockito.anyInt())).thenReturn(expectedPlanet);
        Mockito.when(moveProbeUseCase.execute(Mockito.any())).thenReturn(expectedProbe);
        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);
        Assertions.assertNotNull(actualOutput);

        Mockito.verify(planetGateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        planetId ->
                                Objects.equals(expectedPlanet.get().getId(), planetId))
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
                .create(ArgumentMatchers.argThat(
                        probe ->
                                Objects.equals(expectedProbe.getPositionX(), probe.getPositionX())
                                        && Objects.equals(expectedProbe.getPositionY(), probe.getPositionY())
                                        && Objects.equals(expectedProbe.getDirection(), probe.getDirection())
                                        && Objects.equals(expectedPlanet.get().getId(), probe.getPlanet().getId())
                ));
    }

    @Test
    public void givenAInvalidCommandPlanetId_whenCallsCreateProbe_shouldReturnNotFoundException() {
        final var expectedProbe = Probe.newProbe(1, 1, Direction.NORTH, null);
        final var expectedErrorMessage = "Planet with ID 0 was not found";
        final var movementCommand = Collections.<Command>emptyList();
        final var command = CreateProbeCommand.with(
                expectedProbe.getPositionX(),
                expectedProbe.getPositionY(),
                expectedProbe.getDirection(),
                movementCommand,
                0);

        Mockito.when(planetGateway.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        final var actualException = Assertions.assertThrows(NotFoundException.class, () -> useCase.execute(command));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
        Mockito.verify(planetGateway, Mockito.times(1)).findById(Mockito.anyInt());
        Mockito.verify(gateway, Mockito.times(0)).create(Mockito.any());
    }
}

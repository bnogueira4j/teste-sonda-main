package br.com.elo7.sonda.candidato.application.probe.retrieve.get;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class GetProbeByIdUseCaseTest {

    @InjectMocks
    private DefaultGetProbeByIdUseCase useCase;

    @Mock
    private ProbeGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsGetProbeById_shouldReturnProbeOutput() {
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));
        final var expectedProbe = Probe.newProbe(1, 1, Direction.NORTH, expectedPlanet.get());


        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.of(expectedProbe));

        final var actualOutput = useCase.execute(expectedProbe.getId());
        Assertions.assertNotNull(actualOutput);

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        probeId ->
                                Objects.equals(expectedProbe.getId(), probeId))
                );
    }

    @Test
    public void givenAInvalidCommandProbeId_whenCallsGetProbeById_shouldReturnNotFoundException() {
        final var expectedErrorMessage = "Probe with ID 0 was not found";

        final var probeIdCommand = 0;

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        final var actualException = Assertions.assertThrows(NotFoundException.class, () -> useCase.execute(probeIdCommand));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
        Mockito.verify(gateway, Mockito.times(1)).findById(Mockito.anyInt());
    }
}

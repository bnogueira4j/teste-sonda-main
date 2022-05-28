package br.com.elo7.sonda.candidato.application.probe.retrieve.list;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.domain.probe.ProbeGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class ListProbesUseCaseTest {

    @InjectMocks
    private DefaultListProbesUseCase useCase;

    @Mock
    private ProbeGateway gateway;

    @Test
    public void whenCallsListProbes_shouldReturnListOfProbeOutput() {
        final var expectedPlanet = Optional.of(new Planet(1, 10, 10));
        final var expectedListProbe = List.of(Probe.newProbe(1, 1, Direction.NORTH, expectedPlanet.get()));

        Mockito.when(gateway.findAll()).thenReturn(expectedListProbe);

        final var actualOutput = useCase.execute();
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedListProbe.size(), actualOutput.size());

        Mockito.verify(gateway, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCallsListProbes_shouldReturnListEmpty() {
        final var expectedListProbe = Collections.emptyList();

        Mockito.when(gateway.findAll()).thenReturn(Collections.emptyList());

        final var actualOutput = useCase.execute();
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedListProbe.size(), actualOutput.size());

        Mockito.verify(gateway, Mockito.times(1)).findAll();
    }
}

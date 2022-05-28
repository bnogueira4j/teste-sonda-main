package br.com.elo7.sonda.candidato.application.planet.retrieve.list;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ListPlanetsUseCaseTest {

    @InjectMocks
    private DefaultListPlanetsUseCase useCase;

    @Mock
    private PlanetGateway gateway;

    @Test
    public void whenCallsListPlanets_shouldReturnListOfPlanetOutput() {
        final var expectedListPlanet = List.of(Planet.newPlanet(10,10));

        Mockito.when(gateway.findAll()).thenReturn(expectedListPlanet);

        final var actualOutput = useCase.execute();
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedListPlanet.size(), actualOutput.size());

        Mockito.verify(gateway, Mockito.times(1)).findAll();
    }

    @Test
    public void whenCallsListPlanets_shouldReturnListEmpty() {
        final var expectedListPlanet = Collections.emptyList();

        Mockito.when(gateway.findAll()).thenReturn(Collections.emptyList());

        final var actualOutput = useCase.execute();
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedListPlanet.size(), actualOutput.size());

        Mockito.verify(gateway, Mockito.times(1)).findAll();
    }
}

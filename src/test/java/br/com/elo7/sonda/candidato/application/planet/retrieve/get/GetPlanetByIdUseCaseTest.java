package br.com.elo7.sonda.candidato.application.planet.retrieve.get;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
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
public class GetPlanetByIdUseCaseTest {

    @InjectMocks
    private DefaultGetPlanetByIdUseCase useCase;

    @Mock
    private PlanetGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsGetPlanetById_shouldReturnPlanetOutput() {
        final var expectedPlanet = new Planet(1, 10, 10);

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.of(expectedPlanet));

        final var actualOutput = useCase.execute(expectedPlanet.getId());
        Assertions.assertNotNull(actualOutput);
        Assertions.assertEquals(expectedPlanet.getHeight(), actualOutput.height());
        Assertions.assertEquals(expectedPlanet.getWidth(), actualOutput.width());

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        planetId ->
                                Objects.equals(expectedPlanet.getId(), planetId))
                );
    }

    @Test
    public void givenAInvalidCommandPlanetId_whenCallsGetPlanetById_shouldReturnNotFoundException() {
        final var expectedErrorMessage = "Planet with ID 0 was not found";

        final var planetIdCommand = 0;

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        final var actualException = Assertions.assertThrows(NotFoundException.class, () -> useCase.execute(planetIdCommand));

        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());
        Mockito.verify(gateway, Mockito.times(1)).findById(Mockito.anyInt());
    }
}

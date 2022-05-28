package br.com.elo7.sonda.candidato.application.planet.create;

import br.com.elo7.sonda.candidato.domain.exceptions.DomainException;
import br.com.elo7.sonda.candidato.domain.planet.Planet;
import br.com.elo7.sonda.candidato.domain.planet.PlanetGateway;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Objects;

@ExtendWith(MockitoExtension.class)
public class CreatePlanetUseCaseTest {

    @InjectMocks
    private DefaultCreatePlanetUseCase useCase;

    @Mock
    private PlanetGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsCreatePlanet_shouldReturnPlanetId() {
        final var expectedWidth = 10;
        final var expectedHeight = 10;

        final var command = CreatePlanetCommand.with(expectedWidth, expectedHeight);

        Mockito.when(gateway.create(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);

        Mockito.verify(gateway, Mockito.times(1))
                .create(ArgumentMatchers.argThat(
                        planet ->
                                Objects.equals(expectedWidth, planet.getWidth())
                                        && Objects.equals(expectedHeight, planet.getHeight())
                ));
    }

    @Test
    public void givenAInvalidWidth_whenCallsCreatePlanet_shouldReturnDomainException() {
        final var expectedWidth = 0;
        final var expectedHeight = 10;
        final var expectedErrorMessage = "'width' should not be less or equal zero";
        Planet.newPlanet(expectedWidth, expectedHeight);

        final var command = CreatePlanetCommand.with(expectedWidth, expectedHeight);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> useCase.execute(command));
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        Mockito.verify(gateway, Mockito.times(0)).create(Mockito.any());
    }

    @Test
    public void givenAInValidHeight_whenCallsCreatePlanet_shouldReturnDomainException() {
        final var expectedWidth = 10;
        final var expectedHeight = -2;
        final var expectedErrorMessage = "'height' should not be less or equal zero";
        Planet.newPlanet(expectedWidth, expectedHeight);

        final var command = CreatePlanetCommand.with(expectedWidth, expectedHeight);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> useCase.execute(command));
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        Mockito.verify(gateway, Mockito.times(0)).create(Mockito.any());
    }

}

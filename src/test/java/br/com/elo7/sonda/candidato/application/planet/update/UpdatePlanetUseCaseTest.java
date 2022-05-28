package br.com.elo7.sonda.candidato.application.planet.update;

import br.com.elo7.sonda.candidato.application.exceptions.NotFoundException;
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
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class UpdatePlanetUseCaseTest {

    @InjectMocks
    private DefaultUpdatePlanetUseCase useCase;

    @Mock
    private PlanetGateway gateway;

    @Test
    public void givenAValidCommand_whenCallsUpdatePlanet_shouldReturnPlanetOutput() {
        final var expectedId = 1;
        final var expectedWidth = 15;
        final var expectedHeight = 20;

        final var actualPlanet = Optional.of(new Planet(expectedId, 10, 10));

        final var command = UpdatePlanetCommand.with(expectedId, expectedWidth, expectedHeight);

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(actualPlanet);
        Mockito.when(gateway.update(Mockito.any())).thenAnswer(AdditionalAnswers.returnsFirstArg());

        final var actualOutput = useCase.execute(command);

        Assertions.assertNotNull(actualOutput);

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        planetId ->
                                Objects.equals(expectedId, planetId)
                ));

        Mockito.verify(gateway, Mockito.times(1))
                .update(ArgumentMatchers.argThat(
                        planet ->
                                Objects.equals(expectedId, planet.getId())
                                        && Objects.equals(expectedWidth, planet.getWidth())
                                        && Objects.equals(expectedHeight, planet.getHeight())
                ));
    }

    @Test
    public void givenAInvalidId_whenCallsUpdatePlanet_shouldReturnNotFoundException() {
        final var expectedId = 0;
        final var expectedWidth = 10;
        final var expectedHeight = 15;
        final var expectedErrorMessage = "Planet with ID %s was not found".formatted(expectedId);

        final var command = UpdatePlanetCommand.with(expectedId, expectedWidth, expectedHeight);

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        final var actualException = Assertions.assertThrows(NotFoundException.class, () -> useCase.execute(command));
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        planetId ->
                                Objects.equals(expectedId, planetId)
                ));

        Mockito.verify(gateway, Mockito.times(0))
                .update(Mockito.any());
    }

    @Test
    public void givenAInvalidWidth_whenCallsUpdatePlanet_shouldReturnDomainException() {
        final var expectedId = 1;
        final var expectedWidth = 0;
        final var expectedHeight = 10;
        final var expectedErrorMessage = "'width' should not be less or equal zero";

        final var actualPlanet = Optional.of(new Planet(expectedId, 10, 10));

        final var command = UpdatePlanetCommand.with(expectedId, expectedWidth, expectedHeight);

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(actualPlanet);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> useCase.execute(command));
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        planetId ->
                                Objects.equals(expectedId, planetId)
                ));

        Mockito.verify(gateway, Mockito.times(0)).update(Mockito.any());
    }

    @Test
    public void givenAInvalidHeight_whenCallsUpdatePlanet_shouldReturnDomainException() {
        final var expectedId = 1;
        final var expectedWidth = 10;
        final var expectedHeight = -5;
        final var expectedErrorMessage = "'height' should not be less or equal zero";

        final var actualPlanet = Optional.of(new Planet(expectedId, 10, 10));

        final var command = UpdatePlanetCommand.with(expectedId, expectedWidth, expectedHeight);

        Mockito.when(gateway.findById(Mockito.anyInt())).thenReturn(actualPlanet);

        final var actualException = Assertions.assertThrows(DomainException.class, () -> useCase.execute(command));
        Assertions.assertEquals(expectedErrorMessage, actualException.getMessage());

        Mockito.verify(gateway, Mockito.times(1))
                .findById(ArgumentMatchers.intThat(
                        planetId ->
                                Objects.equals(expectedId, planetId)
                ));

        Mockito.verify(gateway, Mockito.times(0)).update(Mockito.any());
    }

}

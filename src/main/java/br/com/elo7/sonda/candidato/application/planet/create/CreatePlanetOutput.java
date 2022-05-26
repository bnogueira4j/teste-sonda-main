package br.com.elo7.sonda.candidato.application.planet.create;

import br.com.elo7.sonda.candidato.domain.planet.Planet;

public record CreatePlanetOutput(
        int id
) {
    public static CreatePlanetOutput from(
            final Planet planet
    ) {
        return new CreatePlanetOutput(planet.getId());
    }
}

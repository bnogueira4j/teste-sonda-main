package br.com.elo7.sonda.candidato.application.planet.common;

import br.com.elo7.sonda.candidato.domain.planet.Planet;

public record PlanetOutput(
        int id,
        int width,
        int height
) {
    public static PlanetOutput from(final Planet planet) {
        return new PlanetOutput(planet.getId(), planet.getWidth(), planet.getHeight());
    }
}

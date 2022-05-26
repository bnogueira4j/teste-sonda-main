package br.com.elo7.sonda.candidato.application.planet.retrieve.list;

import br.com.elo7.sonda.candidato.domain.planet.Planet;

public record PlanetListOutput(
        int id,
        int width,
        int height
) {
    public static PlanetListOutput from(final Planet planet) {
        return new PlanetListOutput(planet.getId(), planet.getWidth(), planet.getHeight());
    }
}

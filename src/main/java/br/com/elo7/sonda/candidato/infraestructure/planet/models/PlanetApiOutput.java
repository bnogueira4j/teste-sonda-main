package br.com.elo7.sonda.candidato.infraestructure.planet.models;

import br.com.elo7.sonda.candidato.application.planet.common.PlanetOutput;

public record PlanetApiOutput(int id, int width, int height) {

    public static PlanetApiOutput from(final PlanetOutput output) {
        return new PlanetApiOutput(output.id(), output.width(), output.height());
    }
}

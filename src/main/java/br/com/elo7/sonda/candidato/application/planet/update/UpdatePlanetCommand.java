package br.com.elo7.sonda.candidato.application.planet.update;

public record UpdatePlanetCommand(
        int id,
        int width,
        int height
) {
    public static UpdatePlanetCommand with(
            final int id,
            final int width,
            final int height
    ) {
        return new UpdatePlanetCommand(id, width, height);
    }
}

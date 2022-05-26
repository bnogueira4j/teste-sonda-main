package br.com.elo7.sonda.candidato.application.planet.create;

public record CreatePlanetCommand(
        int width,
        int height
) {
    public static CreatePlanetCommand with(
            final int width,
            final int height
    ) {
        return new CreatePlanetCommand(width, height);
    }
}

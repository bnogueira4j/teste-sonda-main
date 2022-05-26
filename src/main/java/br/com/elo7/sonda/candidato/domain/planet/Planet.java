package br.com.elo7.sonda.candidato.domain.planet;

import br.com.elo7.sonda.candidato.domain.Entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Planet extends Entity {
    @Min(0)
    private int id;
    @NotEmpty
    private int width;
    @NotEmpty
    private int height;

    public static Planet newPlanet(final int width, final int height) {
		return new Planet(width, height);
    }

	private Planet(int width, int height) {
		this.width = width;
		this.height = height;
	}

	public Planet(int id, int width, int height) {
		this.id = id;
		this.width = width;
		this.height = height;
	}

	public int getId() {
		return id;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	@Override
	public void validate() {
		new PlanetValidator(this).validate();
	}
}

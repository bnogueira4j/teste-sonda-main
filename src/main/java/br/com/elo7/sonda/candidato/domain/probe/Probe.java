package br.com.elo7.sonda.candidato.domain.probe;

import br.com.elo7.sonda.candidato.domain.planet.Planet;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

public class Probe {
    @Min(0)
    private int id;
    @NotEmpty
    private int positionX;
    @NotEmpty
    private int positionY;
    @NotEmpty
    private Direction direction;
    @NotEmpty
    private Planet planet;

    public Probe(int positionX, int positionY, Direction direction, Planet planet) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.planet = planet;
    }

    public static Probe newProbe(final int positionX, final int positionY, Direction direction, Planet planet) {
        return new Probe(positionX, positionY, direction, planet);
    }

    public Probe(int id, int positionX, int positionY, Direction direction, Planet planet) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.planet = planet;
    }

    public int getId() {
        return id;
    }

    public int getPositionX() {
        return positionX;
    }

    public void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Planet getPlanet() {
        return planet;
    }
}

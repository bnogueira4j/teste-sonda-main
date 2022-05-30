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

    private void setPositionX(int positionX) {
        this.positionX = positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    private void setPositionY(int positionY) {
        this.positionY = positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    private void setDirection(Direction direction) {
        this.direction = direction;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void turnLeft() {
        this.setDirection(this.getDirection().turnLeft());
    }

    public void turnRight() {
        this.setDirection(this.getDirection().turnRight());
    }

    public void moveForward() {
        switch (this.getDirection()) {
            case NORTH -> this.setPositionY(++positionY);
            case WEST -> this.setPositionX(--positionX);
            case SOUTH -> this.setPositionY(--positionY);
            case EAST -> this.setPositionX(++positionX);
        }
    }
}

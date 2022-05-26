package br.com.elo7.sonda.candidato.infraestructure.probe.persistence;

import br.com.elo7.sonda.candidato.domain.probe.Direction;
import br.com.elo7.sonda.candidato.domain.probe.Probe;
import br.com.elo7.sonda.candidato.infraestructure.planet.persistence.PlanetEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PROBE")
public class ProbeEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "probeSeq")
    @SequenceGenerator(name = "probeSeq", sequenceName = "probe_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "position_x", nullable = false)
    private int positionX;
    @Column(name = "position_y", nullable = false)
    private int positionY;
    @Column(name = "direction", nullable = false)
    private Direction direction;
    @ManyToOne
    @JoinColumn(name = "planet_id", nullable = false)
    private PlanetEntity planet;

    public ProbeEntity(final int id, final int positionX, final int positionY, final Direction direction, final PlanetEntity planet) {
        this.id = id;
        this.positionX = positionX;
        this.positionY = positionY;
        this.direction = direction;
        this.planet = planet;
    }

    public ProbeEntity() {

    }

    public int getId() {
        return id;
    }

    public int getPositionX() {
        return positionX;
    }

    public int getPositionY() {
        return positionY;
    }

    public Direction getDirection() {
        return direction;
    }

    public PlanetEntity getPlanet() {
        return planet;
    }

    public static ProbeEntity from(final Probe probe) {
        return new ProbeEntity(
                probe.getId(),
                probe.getPositionX(),
                probe.getPositionY(),
                probe.getDirection(),
                PlanetEntity.from(probe.getPlanet()));
    }

    public Probe toAggregate() {
        return new Probe(getId(), getPositionX(), getPositionY(), getDirection(), getPlanet().toAggregate());
    }
}

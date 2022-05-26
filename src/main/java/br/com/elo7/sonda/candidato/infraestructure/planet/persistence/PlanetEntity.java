package br.com.elo7.sonda.candidato.infraestructure.planet.persistence;

import br.com.elo7.sonda.candidato.domain.planet.Planet;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "PLANET")
@Data
@NoArgsConstructor
public class PlanetEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "planetSeq")
    @SequenceGenerator(name = "planetSeq", sequenceName = "planet_id_seq", allocationSize = 1)
    private int id;
    @Column(name = "width", nullable = false)
    private int width;
    @Column(name = "height", nullable = false)
    private int height;

    private PlanetEntity(final int id, final int width, final int height) {
        this.id = id;
        this.width = width;
        this.height = height;
    }

    public static PlanetEntity from(final Planet planet){
        return new PlanetEntity(planet.getId(), planet.getWidth(), planet.getHeight());
    }

    public Planet toAggregate(){
        return new Planet(getId(), getWidth(), getHeight());
    }
}

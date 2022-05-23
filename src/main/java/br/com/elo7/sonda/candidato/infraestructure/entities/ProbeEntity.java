package br.com.elo7.sonda.candidato.infraestructure.entities;

import br.com.elo7.sonda.candidato.core.domain.Direction;
import br.com.elo7.sonda.candidato.core.domain.Planet;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

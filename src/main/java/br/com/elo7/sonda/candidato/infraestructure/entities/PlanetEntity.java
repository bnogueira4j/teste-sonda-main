package br.com.elo7.sonda.candidato.infraestructure.entities;

import br.com.elo7.sonda.candidato.core.domain.Probe;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "PLANET")
@Data
@AllArgsConstructor
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
//    @OneToMany
//    private List<Probe> probres;
}

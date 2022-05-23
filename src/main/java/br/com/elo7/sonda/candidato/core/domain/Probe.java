package br.com.elo7.sonda.candidato.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
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
}

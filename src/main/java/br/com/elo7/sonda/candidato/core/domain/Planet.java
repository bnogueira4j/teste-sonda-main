package br.com.elo7.sonda.candidato.core.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Planet {
	@Min(0)
	private int id;
	@NotEmpty
	private int width;
	@NotEmpty
	private int height;
}

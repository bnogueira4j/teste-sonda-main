package br.com.elo7.sonda.candidato.domain.planet;

import br.com.elo7.sonda.candidato.domain.Validator;
import br.com.elo7.sonda.candidato.domain.exceptions.DomainException;

public class PlanetValidator extends Validator {
    private final Planet planet;

    public PlanetValidator(final Planet planet) {
        this.planet = planet;
    }

    @Override
    public void validate() {
        if (this.planet.getWidth() <= 0) {
            throw DomainException.with(new Error("'width' should not be less or equal zero"));
        } else if (this.planet.getHeight() <= 0) {
            throw DomainException.with(new Error("'height' should not be less or equal zero"));
        }
    }
}

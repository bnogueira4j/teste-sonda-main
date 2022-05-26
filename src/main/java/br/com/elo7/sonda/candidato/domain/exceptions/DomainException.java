package br.com.elo7.sonda.candidato.domain.exceptions;

import java.util.List;

public class DomainException extends RuntimeException {

    private final List<Error> errors;
    public DomainException(final String aMessage, final List<Error> anErrors) {
        super(aMessage);
        this.errors = anErrors;
    }

    public static DomainException with(final Error anError) {
        return new DomainException(anError.getMessage(), List.of(anError));
    }

    public static DomainException with(final List<Error> anErrors) {
        return new DomainException("", anErrors);
    }

}

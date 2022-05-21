package br.com.elo7.sonda.candidato.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Command {
    @JsonProperty("L") LEFT,
    @JsonProperty("M") MOVE,
    @JsonProperty("R") RIGHT
}

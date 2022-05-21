package br.com.elo7.sonda.candidato.core.domain;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Direction {
    @JsonProperty("N") NORTH,
    @JsonProperty("E") EAST,
    @JsonProperty("W") WEST,
    @JsonProperty("S") SOUTH
}
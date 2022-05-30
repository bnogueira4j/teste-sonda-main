package br.com.elo7.sonda.candidato.domain.probe;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Direction {
    @JsonProperty("N") NORTH {
        @Override
        public Direction turnLeft() {
            return WEST;
        }

        @Override
        public Direction turnRight() {
            return EAST;
        }
    },
    @JsonProperty("E") EAST {
        @Override
        public Direction turnLeft() {
            return NORTH;
        }

        @Override
        public Direction turnRight() {
            return SOUTH;
        }
    },
    @JsonProperty("W") WEST {
        @Override
        public Direction turnLeft() {
            return SOUTH;
        }

        @Override
        public Direction turnRight() {
            return NORTH;
        }
    },
    @JsonProperty("S") SOUTH {
        @Override
        public Direction turnLeft() {
            return EAST;
        }

        @Override
        public Direction turnRight() {
            return WEST;
        }
    };

    public abstract Direction turnLeft();

    public abstract Direction turnRight();
}
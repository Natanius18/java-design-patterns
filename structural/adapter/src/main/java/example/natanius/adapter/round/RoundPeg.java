package example.natanius.adapter.round;

import lombok.Getter;

@Getter
public class RoundPeg {
    private double radius;

    public RoundPeg() {}

    public RoundPeg(double radius) {
        this.radius = radius;
    }

}

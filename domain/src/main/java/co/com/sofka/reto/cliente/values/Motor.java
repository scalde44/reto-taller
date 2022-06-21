package co.com.sofka.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Motor implements ValueObject<Motor.Motores> {
    public enum Motores {
        MONOCILINDRICO, BICILINDRICO, TRICILINDRICO, TETRACILINDRICO, HEXACILINDRICO
    }

    private final Motores motor;

    public Motor(Motores motor) {
        this.motor = Objects.requireNonNull(motor);
    }

    @Override
    public Motores value() {
        return motor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Motor motor1 = (Motor) o;
        return motor.equals(motor1.motor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(motor);
    }
}

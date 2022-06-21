package co.com.sofka.reto.repuesto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Antiguedad implements ValueObject<Integer> {
    private final Integer anios;

    public Antiguedad(int anios) {
        this.anios = anios;
        if (this.anios < 0) {
            throw new IllegalArgumentException("Ingrese una antiguedad valida");
        }
    }

    @Override
    public Integer value() {
        return anios;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Antiguedad that = (Antiguedad) o;
        return anios.intValue() == that.anios.intValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(anios);
    }
}

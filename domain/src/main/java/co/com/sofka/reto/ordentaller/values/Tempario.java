package co.com.sofka.reto.ordentaller.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Tempario implements ValueObject<Integer> {
    private final Integer horas;

    public Tempario(int horas) {
        this.horas = horas;
        if (this.horas <= 0) {
            throw new IllegalArgumentException("Ingresa una cantidad de horas valida");
        }
    }

    @Override
    public Integer value() {
        return horas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tempario tempario = (Tempario) o;
        return horas.equals(tempario.horas);
    }

    @Override
    public int hashCode() {
        return Objects.hash(horas);
    }
}

package co.com.sofka.reto.ordentaller.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Especialidad implements ValueObject<Especialidad.Especialidades> {
    public enum Especialidades {
        MOTOR, ELECTRICO, REVISION
    }

    private final Especialidades especialidad;

    public Especialidad(Especialidades especialidad) {
        this.especialidad = Objects.requireNonNull(especialidad);
    }

    @Override
    public Especialidades value() {
        return especialidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Especialidad that = (Especialidad) o;
        return especialidad.equals(that.especialidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(especialidad);
    }
}

package co.com.sofka.reto.ordentaller.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoTecnico implements ValueObject<EstadoTecnico.EstadosTecnico> {
    public enum EstadosTecnico {
        DISPONIBLE, NO_DISPONIBLE
    }

    private final EstadosTecnico estadoTecnico;

    public EstadoTecnico(EstadosTecnico estadoTecnico) {
        this.estadoTecnico = Objects.requireNonNull(estadoTecnico);
    }

    @Override
    public EstadosTecnico value() {
        return estadoTecnico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoTecnico that = (EstadoTecnico) o;
        return estadoTecnico.equals(that.estadoTecnico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadoTecnico);
    }
}

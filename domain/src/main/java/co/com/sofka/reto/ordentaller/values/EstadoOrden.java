package co.com.sofka.reto.ordentaller.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoOrden implements ValueObject<EstadoOrden.EstadosOrden> {
    public enum EstadosOrden {
        PENDIENTE, PROGRESO, FINALIZADA
    }

    private final EstadosOrden estadoOrden;


    public EstadoOrden(EstadosOrden estadoOrden) {
        this.estadoOrden = Objects.requireNonNull(estadoOrden);
    }

    @Override
    public EstadosOrden value() {
        return estadoOrden;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoOrden that = (EstadoOrden) o;
        return estadoOrden.equals(that.estadoOrden);
    }

    @Override
    public int hashCode() {
        return Objects.hash(estadoOrden);
    }
}

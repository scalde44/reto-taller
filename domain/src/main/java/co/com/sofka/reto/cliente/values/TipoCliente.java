package co.com.sofka.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TipoCliente implements ValueObject<TipoCliente.TipoClientes> {
    private final TipoClientes tipoCliente;

    public enum TipoClientes {
        FRECUENTE, ESPORADICO, NUEVO
    }

    public TipoCliente(TipoClientes tipoCliente) {
        this.tipoCliente = Objects.requireNonNull(tipoCliente);
    }

    @Override
    public TipoClientes value() {
        return tipoCliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoCliente that = (TipoCliente) o;
        return tipoCliente.equals(that.tipoCliente);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipoCliente);
    }
}

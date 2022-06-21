package co.com.sofka.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Kilometraje implements ValueObject<Integer> {
    private final Integer cantidad;

    public Kilometraje(int cantidad) {
        this.cantidad = cantidad;
        if (cantidad < 0) {
            throw new IllegalArgumentException("Ingresa un kilometraje valido");
        }
    }

    @Override
    public Integer value() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kilometraje that = (Kilometraje) o;
        return cantidad.intValue() == that.cantidad.intValue();
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad);
    }
}

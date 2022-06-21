package co.com.sofka.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Vin implements ValueObject<String> {
    private final String valor;

    public Vin(String valor) {
        this.valor = Objects.requireNonNull(valor);
        if (this.valor.isBlank()) {
            throw new IllegalArgumentException("El vin es requerido");
        }
        if (!this.valor.matches("^(?=.*[0-9])(?=.*[A-z])[0-9A-z-]{17}$")) {
            throw new IllegalArgumentException("Ingresa un vin valido");
        }
    }

    @Override
    public String value() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vin vin = (Vin) o;
        return valor.equals(vin.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }
}

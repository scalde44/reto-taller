package co.com.sofka.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Marca implements ValueObject<Marca.Marcas> {
    private final Marcas marca;

    public enum Marcas {
        HONDA, AKT, BAJAJ, SUZUKI, YAMAHA
    }

    public Marca(Marcas marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    @Override
    public Marcas value() {
        return marca;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Marca marca1 = (Marca) o;
        return marca.equals(marca1.marca);
    }

    @Override
    public int hashCode() {
        return Objects.hash(marca);
    }
}

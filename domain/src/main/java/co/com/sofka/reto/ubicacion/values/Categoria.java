package co.com.sofka.reto.ubicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Categoria implements ValueObject<Categoria.Categorias> {
    public enum Categorias {
        MANTENIMIENTO, REPARACION, COLISION, ELECTRICO
    }

    private final Categorias categoria;

    public Categoria(Categorias categoria) {
        this.categoria = Objects.requireNonNull(categoria);
    }

    @Override
    public Categorias value() {
        return categoria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria that = (Categoria) o;
        return categoria.equals(that.categoria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoria);
    }
}

package co.com.sofka.reto.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Nombre implements ValueObject<String> {
    private final String nombre;

    public Nombre(String nombre) {
        this.nombre = Objects.requireNonNull(nombre);
        if (this.nombre.isBlank()) {
            throw new IllegalArgumentException("Se requiere un nombre");
        }
        if (this.nombre.length() < 3) {
            throw new IllegalArgumentException("El nombre es muy corto");
        }
        if (!this.nombre.matches("^[a-zA-ZÀ-ÿ\\u00f1\\u00d1_]+(\\\\s+[a-zA-ZÀ-ÿ\\u00f1\\u00d1_]+)*$")) {
            throw new IllegalArgumentException("Ingresa un nombre valido");
        }
    }

    @Override
    public String value() {
        return nombre;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nombre nombre1 = (Nombre) o;
        return nombre.equalsIgnoreCase(nombre1.nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre);
    }
}

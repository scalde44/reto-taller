package co.com.sofka.reto.ubicacion.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Direccion implements ValueObject<String> {

    private final String pasillo;
    private final String estanteria;
    private final String cubiculo;

    private final String direccion;

    public Direccion(String pasillo, String estanteria, String cubiculo) {
        this.pasillo = Objects.requireNonNull(pasillo);
        this.estanteria = Objects.requireNonNull(estanteria);
        this.cubiculo = Objects.requireNonNull(cubiculo);

        if (this.pasillo.isBlank() || this.estanteria.isBlank() || this.cubiculo.isBlank()) {
            throw new IllegalArgumentException("Los campos no pueden estar vacios");
        }

        this.direccion = formarDireccion(pasillo, estanteria, cubiculo);
    }

    private String formarDireccion(String pasillo, String estanteria, String cubiculo) {
        return pasillo.concat(estanteria).concat(cubiculo);
    }

    @Override
    public String value() {
        return direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direccion direccion1 = (Direccion) o;
        return direccion.equalsIgnoreCase(direccion1.direccion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(direccion);
    }
}

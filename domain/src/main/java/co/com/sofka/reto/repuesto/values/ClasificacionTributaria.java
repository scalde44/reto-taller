package co.com.sofka.reto.repuesto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class ClasificacionTributaria implements ValueObject<ClasificacionTributaria.ClasificacionesTributarias> {
    public enum ClasificacionesTributarias {
        MICRO, PEQUENO, MEDIANO, GRANDE
    }

    private final ClasificacionesTributarias clasificacionTributaria;


    public ClasificacionTributaria(ClasificacionesTributarias clasificacionTributaria) {
        this.clasificacionTributaria = Objects.requireNonNull(clasificacionTributaria);
    }

    @Override
    public ClasificacionesTributarias value() {
        return clasificacionTributaria;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClasificacionTributaria that = (ClasificacionTributaria) o;
        return clasificacionTributaria.equals(that.clasificacionTributaria);
    }

    @Override
    public int hashCode() {
        return Objects.hash(clasificacionTributaria);
    }
}

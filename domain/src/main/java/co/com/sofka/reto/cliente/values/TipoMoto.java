package co.com.sofka.reto.cliente.values;

import co.com.sofka.domain.generic.ValueObject;

import java.time.LocalDate;
import java.util.Objects;

public class TipoMoto implements ValueObject<String> {
    private final Integer modelo;
    private final String tipo;
    private final String formato;

    public TipoMoto(int modelo, String tipo) {
        this.modelo = modelo;
        if (this.modelo < 1950) {
            throw new IllegalArgumentException("Ingresa un modelo de la moto valido");
        }
        if (this.modelo > LocalDate.now().getYear() + 1) {
            throw new IllegalArgumentException("Ingresa un modelo de la moto valido");
        }
        this.tipo = Objects.requireNonNull(tipo);
        if (this.tipo.isBlank()) {
            throw new IllegalArgumentException("Se requiere un tipo de moto");
        }
        if (this.tipo.length() < 3) {
            throw new IllegalArgumentException("Ingresa un tipo valido");
        }
        this.formato = generarFormato();
    }

    private String generarFormato() {
        return this.tipo.concat(this.modelo.toString());
    }

    @Override
    public String value() {
        return this.formato;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoMoto tipoMoto = (TipoMoto) o;
        return formato.equals(tipoMoto.formato);
    }

    @Override
    public int hashCode() {
        return Objects.hash(formato);
    }
}

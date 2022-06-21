package co.com.sofka.reto.generic.values;

import co.com.sofka.domain.generic.ValueObject;

import java.math.BigDecimal;
import java.util.Objects;

public class Valor implements ValueObject<BigDecimal> {
    private final BigDecimal monto;

    public Valor(BigDecimal monto) {
        this.monto = Objects.requireNonNull(monto);
        if (this.monto.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Ingresa un monto valido");
        }
    }

    @Override
    public BigDecimal value() {
        return monto;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Valor valor = (Valor) o;
        return monto.equals(valor.monto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(monto);
    }
}

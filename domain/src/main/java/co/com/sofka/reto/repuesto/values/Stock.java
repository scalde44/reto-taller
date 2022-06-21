package co.com.sofka.reto.repuesto.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Stock implements ValueObject<Integer> {

    private final Integer cantidad;

    public Stock(int cantidad) {
        if (cantidad < 0) {
            throw new IllegalArgumentException("La cantidad no deber ser menor a cero");
        }
        this.cantidad = cantidad;
    }

    public Stock aumentar(Stock otro) {
        return new Stock(cantidad + otro.value());
    }

    public Stock disminuir(Stock otro) {
        return new Stock(cantidad - otro.value());
    }

    @Override
    public Integer value() {
        return cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return cantidad.equals(stock.cantidad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cantidad);
    }
}

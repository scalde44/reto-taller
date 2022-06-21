package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.repuesto.values.Stock;

public class StockAumentado extends DomainEvent {
    private final Stock stock;

    public StockAumentado(Stock stock) {
        super("reto.repuesto.stockdisminuido");
        this.stock = stock;
    }

    public Stock getStock() {
        return stock;
    }
}

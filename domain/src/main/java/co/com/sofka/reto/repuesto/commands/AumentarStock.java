package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
import co.com.sofka.reto.repuesto.values.Stock;

public class AumentarStock extends Command {
    private final RepuestoId repuestoId;
    private final Stock stock;

    public AumentarStock(RepuestoId repuestoId, Stock stock) {
        this.repuestoId = repuestoId;
        this.stock = stock;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public Stock getStock() {
        return stock;
    }
}

package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Valor;

public class ValorActualizado extends DomainEvent {
    private final Valor valor;

    public ValorActualizado(Valor valor) {
        super("reto.repuesto.valoractualizado");
        this.valor = valor;
    }

    public Valor getValor() {
        return valor;
    }
}

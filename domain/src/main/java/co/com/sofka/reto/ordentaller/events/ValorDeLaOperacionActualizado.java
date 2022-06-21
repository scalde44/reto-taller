package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.identities.OperacionId;

public class ValorDeLaOperacionActualizado extends DomainEvent {
    private final OperacionId operacionId;
    private final Valor valor;

    public ValorDeLaOperacionActualizado(OperacionId operacionId, Valor valor) {
        super("reto.ordentaller.valordelaoperacionactualizado");
        this.operacionId = operacionId;
        this.valor = valor;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Valor getValor() {
        return valor;
    }
}

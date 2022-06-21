package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.values.Tempario;

public class TemparioDeLaOperacionActualizado extends DomainEvent {
    private final OperacionId operacionId;
    private final Tempario tempario;

    public TemparioDeLaOperacionActualizado(OperacionId operacionId, Tempario tempario) {
        super("reto.ordentaller.tempariodelaoperacionactualizado");
        this.operacionId = operacionId;
        this.tempario = tempario;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Tempario getTempario() {
        return tempario;
    }
}

package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

public class RepuestoAgregadoALaOrdenDeTaller extends DomainEvent {
    private final RepuestoId repuestoId;

    public RepuestoAgregadoALaOrdenDeTaller(RepuestoId repuestoId) {
        super("reto.ordentaller.repuestoagregadoalaordendetaller");
        this.repuestoId = repuestoId;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }
}

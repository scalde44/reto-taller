package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ordentaller.values.EstadoOrden;

public class EstadoOrdenDeTallerCambiado extends DomainEvent {
    private final EstadoOrden estadoOrden;

    public EstadoOrdenDeTallerCambiado(EstadoOrden estadoOrden) {
        super("reto.ordentaller.estadoordendetallercambiado");
        this.estadoOrden = estadoOrden;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }
}

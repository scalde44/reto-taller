package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.values.EstadoOrden;

public class CambiarEstadoOrdenDeTaller extends Command {
    private final OrdenTallerId ordenTallerId;
    private final EstadoOrden estadoOrden;

    public CambiarEstadoOrdenDeTaller(OrdenTallerId ordenTallerId, EstadoOrden estadoOrden) {
        this.ordenTallerId = ordenTallerId;
        this.estadoOrden = estadoOrden;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public EstadoOrden getEstadoOrden() {
        return estadoOrden;
    }
}

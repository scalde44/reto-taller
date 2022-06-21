package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

public class AgregarRepuestoALaOrdenDeTaller extends Command {
    private final OrdenTallerId ordenTallerId;
    private final RepuestoId repuestoId;

    public AgregarRepuestoALaOrdenDeTaller(OrdenTallerId ordenTallerId, RepuestoId repuestoId) {
        this.ordenTallerId = ordenTallerId;
        this.repuestoId = repuestoId;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }
}

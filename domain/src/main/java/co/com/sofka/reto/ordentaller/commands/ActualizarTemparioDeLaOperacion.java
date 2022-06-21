package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.values.Tempario;

public class ActualizarTemparioDeLaOperacion extends Command {
    private final OrdenTallerId ordenTallerId;
    private final OperacionId operacionId;
    private final Tempario tempario;

    public ActualizarTemparioDeLaOperacion(OrdenTallerId ordenTallerId, OperacionId operacionId, Tempario tempario) {
        this.ordenTallerId = ordenTallerId;
        this.operacionId = operacionId;
        this.tempario = tempario;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Tempario getTempario() {
        return tempario;
    }
}

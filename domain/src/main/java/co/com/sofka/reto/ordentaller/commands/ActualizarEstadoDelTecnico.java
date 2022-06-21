package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;

public class ActualizarEstadoDelTecnico extends Command {
    private final OrdenTallerId ordenTallerId;
    private final TecnicoId tecnicoId;
    private final EstadoTecnico estadoTecnico;

    public ActualizarEstadoDelTecnico(OrdenTallerId ordenTallerId, TecnicoId tecnicoId, EstadoTecnico estadoTecnico) {
        this.ordenTallerId = ordenTallerId;
        this.tecnicoId = tecnicoId;
        this.estadoTecnico = estadoTecnico;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public EstadoTecnico getEstadoTecnico() {
        return estadoTecnico;
    }
}

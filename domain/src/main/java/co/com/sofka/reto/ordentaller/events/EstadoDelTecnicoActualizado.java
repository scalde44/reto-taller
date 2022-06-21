package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;

public class EstadoDelTecnicoActualizado extends DomainEvent {
    private final TecnicoId tecnicoId;
    private final EstadoTecnico estadoTecnico;

    public EstadoDelTecnicoActualizado(TecnicoId tecnicoId, EstadoTecnico estadoTecnico) {
        super("reto.ordentaller.estadodeltecnicoactualizado");
        this.tecnicoId = tecnicoId;
        this.estadoTecnico = estadoTecnico;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public EstadoTecnico getEstadoTecnico() {
        return estadoTecnico;
    }
}

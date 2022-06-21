package co.com.sofka.reto.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.values.Estado;

public class EstadoDelEspacioActualizado extends DomainEvent {
    private final EspacioId espacioId;
    private final Estado estado;

    public EstadoDelEspacioActualizado(EspacioId espacioId, Estado estado) {
        super("reto.ubicacion.estadodelespacioactualizado");
        this.espacioId = espacioId;
        this.estado = estado;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public Estado getEstado() {
        return estado;
    }
}

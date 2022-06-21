package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;

public class UbicacionAsignada extends DomainEvent {
    private final UbicacionId ubicacionId;

    public UbicacionAsignada(UbicacionId ubicacionId) {
        super("reto.repuesto.ubicacionasignada");
        this.ubicacionId = ubicacionId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }
}

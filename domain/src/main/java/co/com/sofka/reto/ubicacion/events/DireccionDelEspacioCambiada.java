package co.com.sofka.reto.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.values.Direccion;

public class DireccionDelEspacioCambiada extends DomainEvent {
    private final EspacioId espacioId;
    private final Direccion direccion;

    public DireccionDelEspacioCambiada(EspacioId espacioId, Direccion direccion) {
        super("reto.ubicacion.direcciondelespaciocambiada");
        this.espacioId = espacioId;
        this.direccion = direccion;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}

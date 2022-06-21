package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.ProveedorId;

public class NombreDelProveedorCambiado extends DomainEvent {
    private final ProveedorId proveedorId;
    private final Nombre nombre;

    public NombreDelProveedorCambiado(ProveedorId proveedorId, Nombre nombre) {
        super("reto.repuesto.nombredelproveedorcambiado");
        this.proveedorId = proveedorId;
        this.nombre = nombre;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

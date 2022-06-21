package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;

public class ClasificacionTributarioDelProveedorActualizada extends DomainEvent {
    private final ProveedorId proveedorId;
    private final ClasificacionTributaria clasificacionTributaria;

    public ClasificacionTributarioDelProveedorActualizada(ProveedorId proveedorId, ClasificacionTributaria clasificacionTributaria) {
        super("reto.repuesto.clasificaciontributariadelproveedoractualizada");
        this.proveedorId = proveedorId;
        this.clasificacionTributaria = clasificacionTributaria;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public ClasificacionTributaria getClasificacionTributaria() {
        return clasificacionTributaria;
    }
}

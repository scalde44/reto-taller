package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.AsesorId;

public class NombreDelAsesorCambiado extends DomainEvent {
    private final AsesorId asesorId;
    private final Nombre nombre;

    public NombreDelAsesorCambiado(AsesorId asesorId, Nombre nombre) {
        super("reto.repuesto.nombredelasesorcambiado");
        this.asesorId = asesorId;
        this.nombre = nombre;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

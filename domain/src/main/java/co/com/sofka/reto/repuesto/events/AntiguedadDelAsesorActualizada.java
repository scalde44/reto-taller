package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.values.Antiguedad;

public class AntiguedadDelAsesorActualizada extends DomainEvent {
    private final AsesorId asesorId;
    private final Antiguedad antiguedad;

    public AntiguedadDelAsesorActualizada(AsesorId asesorId, Antiguedad antiguedad) {
        super("reto.repuesto.antiguedaddelasesoractualizada");
        this.asesorId = asesorId;
        this.antiguedad = antiguedad;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }
}

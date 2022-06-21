package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
import co.com.sofka.reto.repuesto.values.Antiguedad;

public class ActualizarAntiguedadDelAsesor extends Command {
    private final RepuestoId repuestoId;
    private final AsesorId asesorId;
    private final Antiguedad antiguedad;

    public ActualizarAntiguedadDelAsesor(RepuestoId repuestoId, AsesorId asesorId, Antiguedad antiguedad) {
        this.repuestoId = repuestoId;
        this.asesorId = asesorId;
        this.antiguedad = antiguedad;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }
}

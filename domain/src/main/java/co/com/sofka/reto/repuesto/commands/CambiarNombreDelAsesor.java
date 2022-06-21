package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

public class CambiarNombreDelAsesor extends Command {
    private final RepuestoId repuestoId;
    private final AsesorId asesorId;
    private final Nombre nombre;

    public CambiarNombreDelAsesor(RepuestoId repuestoId, AsesorId asesorId, Nombre nombre) {
        this.repuestoId = repuestoId;
        this.asesorId = asesorId;
        this.nombre = nombre;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;

public class AsignarUbicacion extends Command {
    private final RepuestoId repuestoId;
    private final UbicacionId ubicacionId;

    public AsignarUbicacion(RepuestoId repuestoId, UbicacionId ubicacionId) {
        this.repuestoId = repuestoId;
        this.ubicacionId = ubicacionId;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }
}

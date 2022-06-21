package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;

public class ActualizarClasificacionTributariaDelProveedor extends Command {
    private final RepuestoId repuestoId;
    private final ProveedorId proveedorId;
    private final ClasificacionTributaria clasificacionTributaria;

    public ActualizarClasificacionTributariaDelProveedor(RepuestoId repuestoId, ProveedorId proveedorId, ClasificacionTributaria clasificacionTributaria) {
        this.repuestoId = repuestoId;
        this.proveedorId = proveedorId;
        this.clasificacionTributaria = clasificacionTributaria;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public ClasificacionTributaria getClasificacionTributaria() {
        return clasificacionTributaria;
    }
}

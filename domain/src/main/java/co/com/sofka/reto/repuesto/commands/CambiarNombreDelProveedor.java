package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

public class CambiarNombreDelProveedor extends Command {
    private final RepuestoId repuestoId;
    private final ProveedorId proveedorId;
    private final Nombre nombre;

    public CambiarNombreDelProveedor(RepuestoId repuestoId, ProveedorId proveedorId, Nombre nombre) {
        this.repuestoId = repuestoId;
        this.proveedorId = proveedorId;
        this.nombre = nombre;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

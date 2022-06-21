package co.com.sofka.reto.repuesto;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;

public class Proveedor extends Entity<ProveedorId> {
    private Nombre nombre;
    private ClasificacionTributaria clasificacionTributaria;

    public Proveedor(ProveedorId proveedorId, Nombre nombre, ClasificacionTributaria clasificacionTributaria) {
        super(proveedorId);
        this.nombre = nombre;
        this.clasificacionTributaria = clasificacionTributaria;
    }

    public Nombre nombre() {
        return nombre;
    }

    public ClasificacionTributaria clasificacionTributaria() {
        return clasificacionTributaria;
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void actualizarClasificacionTributaria(ClasificacionTributaria clasificacionTributaria) {
        this.clasificacionTributaria = clasificacionTributaria;
    }
}

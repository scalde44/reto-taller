package co.com.sofka.reto.repuesto;

import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;

import java.util.Objects;

public class ProveedorFactory {
    private Proveedor proveedor;
    private static ProveedorFactory instance;

    private ProveedorFactory() {
    }

    public static ProveedorFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new ProveedorFactory();
            return instance;
        }
        return instance;
    }

    public ProveedorFactory crear(ProveedorId proveedorId, Nombre nombre, ClasificacionTributaria clasificacionTributaria) {
        this.proveedor = new Proveedor(proveedorId, nombre, clasificacionTributaria);
        return this;
    }

    protected Proveedor proveedor() {
        return this.proveedor;
    }
}

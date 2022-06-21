package co.com.sofka.reto.repuesto.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.values.Antiguedad;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;
import co.com.sofka.reto.repuesto.values.Stock;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;

public class RepuestoCreado extends DomainEvent {
    private final ProveedorId proveedorId;
    private final Nombre nombreProveedor;
    private final ClasificacionTributaria clasificacionTributaria;
    private final AsesorId asesorId;
    private final Nombre nombreAsesor;
    private final Antiguedad antiguedad;
    private final UbicacionId ubicacionId;
    private final Stock stock;
    private final Valor valor;

    public RepuestoCreado(ProveedorId proveedorId, Nombre nombreProveedor, ClasificacionTributaria clasificacionTributaria, AsesorId asesorId, Nombre nombreAsesor, Antiguedad antiguedad, UbicacionId ubicacionId, Stock stock, Valor valor) {
        super("reto.repuesto.repuestocreado");
        this.proveedorId = proveedorId;
        this.nombreProveedor = nombreProveedor;
        this.clasificacionTributaria = clasificacionTributaria;
        this.asesorId = asesorId;
        this.nombreAsesor = nombreAsesor;
        this.antiguedad = antiguedad;
        this.ubicacionId = ubicacionId;
        this.stock = stock;
        this.valor = valor;
    }

    public ProveedorId getProveedorId() {
        return proveedorId;
    }

    public Nombre getNombreProveedor() {
        return nombreProveedor;
    }

    public ClasificacionTributaria getClasificacionTributaria() {
        return clasificacionTributaria;
    }

    public AsesorId getAsesorId() {
        return asesorId;
    }

    public Nombre getNombreAsesor() {
        return nombreAsesor;
    }

    public Antiguedad getAntiguedad() {
        return antiguedad;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Stock getStock() {
        return stock;
    }

    public Valor getValor() {
        return valor;
    }
}

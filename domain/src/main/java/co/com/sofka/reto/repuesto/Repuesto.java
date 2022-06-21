package co.com.sofka.reto.repuesto;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.repuesto.events.*;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
import co.com.sofka.reto.repuesto.values.Antiguedad;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;
import co.com.sofka.reto.repuesto.values.Stock;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;

import java.util.List;

public class Repuesto extends AggregateEvent<RepuestoId> {
    protected Proveedor proveedor;
    protected Asesor asesor;
    protected UbicacionId ubicacionId;
    protected Stock stock;
    protected Valor valor;

    public Repuesto(RepuestoId repuestoId, ProveedorFactory proveedorFactory, AsesorFactory asesorFactory, UbicacionId ubicacionId, Stock stock, Valor valor) {
        super(repuestoId);
        subscribe(new RepuestoChange(this));
        var proveedor = proveedorFactory.proveedor();
        var asesor = asesorFactory.asesor();
        appendChange(
                new RepuestoCreado(proveedor.identity(), proveedor.nombre(), proveedor.clasificacionTributaria()
                        , asesor.identity(), asesor.nombre(), asesor.antiguedad(), ubicacionId, stock, valor)
        ).apply();
    }

    private Repuesto(RepuestoId repuestoId) {
        super(repuestoId);
        subscribe(new RepuestoChange(this));
    }

    public static Repuesto from(RepuestoId repuestoId, List<DomainEvent> eventsBy) {
        var repuesto = new Repuesto(repuestoId);
        eventsBy.forEach(repuesto::applyEvent);
        return repuesto;
    }

    public void cambiarNombreDelProveedor(ProveedorId proveedorId, Nombre nombre) {
        appendChange(new NombreDelProveedorCambiado(proveedorId, nombre)).apply();
    }

    public void actualizarClasificacionTributariaDelProveedor(ProveedorId proveedorId, ClasificacionTributaria clasificacionTributaria) {
        appendChange(new ClasificacionTributarioDelProveedorActualizada(proveedorId, clasificacionTributaria)).apply();
    }

    public void cambiarNombreDelAsesor(AsesorId asesorId, Nombre nombre) {
        appendChange(new NombreDelAsesorCambiado(asesorId, nombre)).apply();
    }

    public void actualizarAntiguedadDelAsesor(AsesorId asesorId, Antiguedad antiguedad) {
        appendChange(new AntiguedadDelAsesorActualizada(asesorId, antiguedad)).apply();
    }

    public void disminuirStock(Stock stock) {
        appendChange(new StockDisminuido(stock)).apply();
    }

    public void aumentarStock(Stock stock) {
        appendChange(new StockAumentado(stock)).apply();
    }

    public void asignarUbicacion(UbicacionId ubicacionId) {
        appendChange(new UbicacionAsignada(ubicacionId)).apply();
    }

    public void actualizarValor(Valor valor) {
        appendChange(new ValorActualizado(valor)).apply();
    }
}

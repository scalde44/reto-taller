package co.com.sofka.reto.repuesto;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.repuesto.events.*;

public class RepuestoChange extends EventChange {
    public RepuestoChange(Repuesto repuesto) {
        apply((RepuestoCreado event) -> {
            repuesto.stock = event.getStock();
            repuesto.ubicacionId = event.getUbicacionId();
            repuesto.valor = event.getValor();
            repuesto.asesor = new Asesor(event.getAsesorId(), event.getNombreAsesor(), event.getAntiguedad());
            repuesto.proveedor = new Proveedor(event.getProveedorId(), event.getNombreProveedor(), event.getClasificacionTributaria());
        });

        apply((AntiguedadDelAsesorActualizada event) -> {
            if (!repuesto.asesor.identity().equals(event.getAsesorId())) {
                throw new IllegalArgumentException("El asesor no se encontro");
            }
            repuesto.asesor.actualizarAntiguedad(event.getAntiguedad());
        });

        apply((ClasificacionTributarioDelProveedorActualizada event) -> {
            if (!repuesto.proveedor.identity().equals(event.getProveedorId())) {
                throw new IllegalArgumentException("El proveedor no se encontro");
            }
            repuesto.proveedor.actualizarClasificacionTributaria(event.getClasificacionTributaria());
        });

        apply((NombreDelAsesorCambiado event) -> {
            if (!repuesto.asesor.identity().equals(event.getAsesorId())) {
                throw new IllegalArgumentException("El asesor no se encontro");
            }
            repuesto.asesor.cambiarNombre(event.getNombre());
        });

        apply((NombreDelProveedorCambiado event) -> {
            if (!repuesto.proveedor.identity().equals(event.getProveedorId())) {
                throw new IllegalArgumentException("El proveedor no se encontro");
            }
            repuesto.proveedor.cambiarNombre(event.getNombre());
        });

        apply((StockAumentado event) -> {
            repuesto.stock = repuesto.stock.aumentar(event.getStock());
        });

        apply((StockDisminuido event) -> {
            repuesto.stock = repuesto.stock.disminuir(event.getStock());
        });

        apply((UbicacionAsignada event) -> {
            repuesto.ubicacionId = event.getUbicacionId();
        });

        apply((ValorActualizado event) -> {
            repuesto.valor = event.getValor();
        });
    }
}

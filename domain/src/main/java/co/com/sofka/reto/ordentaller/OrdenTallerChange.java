package co.com.sofka.reto.ordentaller;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.ordentaller.events.*;
import co.com.sofka.reto.ordentaller.values.EstadoOrden;

import java.util.ArrayList;

public class OrdenTallerChange extends EventChange {
    public OrdenTallerChange(OrdenTaller ordenTaller) {
        apply((OrdenDeTallerAbierta event) -> {
            ordenTaller.tecnico = new Tecnico(event.getTecnicoId(), event.getEstadoTecnico(), event.getEspecialidad(), event.getNombre());
            ordenTaller.operacion = new Operacion(event.getOperacionId(), event.getTempario(), event.getCategoria(), event.getValor());
            ordenTaller.clienteId = event.getClienteId();
            ordenTaller.respuestoIds = new ArrayList<>();
            ordenTaller.estadoOrden = new EstadoOrden(EstadoOrden.EstadosOrden.PENDIENTE);
        });

        apply((EstadoOrdenDeTallerCambiado event) -> {
            ordenTaller.estadoOrden = event.getEstadoOrden();
        });

        apply((RepuestoAgregadoALaOrdenDeTaller event) -> {
            ordenTaller.respuestoIds.add(event.getRepuestoId());
        });

        apply((NombreDelTecnicoCambiado event) -> {
            if (!ordenTaller.tecnico.identity().equals(event.getTecnicoId())) {
                throw new IllegalArgumentException("Tecnico no encontrado");
            }
            ordenTaller.tecnico.cambiarNombre(event.getNombre());
        });

        apply((EspecialidadDelTecnicoCambiada event) -> {
            if (!ordenTaller.tecnico.identity().equals(event.getTecnicoId())) {
                throw new IllegalArgumentException("Tecnico no encontrado");
            }
            ordenTaller.tecnico.cambiarEspecialidad(event.getEspecialidad());
        });

        apply((TemparioDeLaOperacionActualizado event) -> {
            if (!ordenTaller.operacion.identity().equals(event.getOperacionId())) {
                throw new IllegalArgumentException("Operacion no encontrada");
            }
            ordenTaller.operacion.actualizarTempario(event.getTempario());
        });

        apply((CategoriaDeLaOperacionCambiada event) -> {
            if (!ordenTaller.operacion.identity().equals(event.getOperacionId())) {
                throw new IllegalArgumentException("Operacion no encontrada");
            }
            ordenTaller.operacion.cambiarCategoria(event.getCategoria());
        });

        apply((ValorDeLaOperacionActualizado event) -> {
            if (!ordenTaller.operacion.identity().equals(event.getOperacionId())) {
                throw new IllegalArgumentException("Operacion no encontrada");
            }
            ordenTaller.operacion.actualizarValor(event.getValor());
        });

        apply((EstadoDelTecnicoActualizado event) -> {
            if (!ordenTaller.tecnico.identity().equals(event.getTecnicoId())) {
                throw new IllegalArgumentException("Tecnico no encontrado");
            }
            ordenTaller.tecnico.actualizarEstado(event.getEstadoTecnico());
        });
    }
}

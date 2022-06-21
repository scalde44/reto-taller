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
            ordenTaller.tecnico.cambiarNombre(event.getNombre());
        });

        apply((EspecialidadDelTecnicoCambiada event) -> {
            ordenTaller.tecnico.cambiarEspecialidad(event.getEspecialidad());
        });

        apply((TemparioDeLaOperacionActualizado event) -> {
            ordenTaller.operacion.actualizarTempario(event.getTempario());
        });

        apply((CategoriaDeLaOperacionCambiada event) -> {
            ordenTaller.operacion.cambiarCategoria(event.getCategoria());
        });

        apply((ValorDeLaOperacionActualizado event) -> {
            ordenTaller.operacion.actualizarValor(event.getValor());
        });

        apply((EstadoDelTecnicoActualizado event) -> {
            ordenTaller.tecnico.actualizarEstado(event.getEstadoTecnico());
        });
    }
}

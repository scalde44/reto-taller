package co.com.sofka.reto.ordentaller;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.events.*;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.*;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

import java.util.List;

public class OrdenTaller extends AggregateEvent<OrdenTallerId> {
    protected Tecnico tecnico;
    protected Operacion operacion;
    protected ClienteId clienteId;
    protected List<RepuestoId> respuestoIds;
    protected EstadoOrden estadoOrden;

    public OrdenTaller(OrdenTallerId ordenTallerId, TecnicoFactory tecnicoFactory, OperacionFactory operacionFactory, ClienteId clienteId) {
        super(ordenTallerId);
        subscribe(new OrdenTallerChange(this));
        var tecnico = tecnicoFactory.tecnico();
        var operacion = operacionFactory.operacion();
        appendChange(
                new OrdenDeTallerAbierta(tecnico.identity(), tecnico.estadoTecnico(), tecnico.nombre(), tecnico.especialidad()
                        , operacion.identity(), operacion.tempario(), operacion.categoria(), operacion.valor(), clienteId)
        ).apply();
    }

    private OrdenTaller(OrdenTallerId ordenTallerId) {
        super(ordenTallerId);
        subscribe(new OrdenTallerChange(this));
    }

    public static OrdenTaller from(OrdenTallerId ordenTallerId, List<DomainEvent> eventsBy) {
        var ordenTaller = new OrdenTaller(ordenTallerId);
        eventsBy.forEach(ordenTaller::applyEvent);
        return ordenTaller;
    }

    public void cambiarEstadoOrdenDeTaller(EstadoOrden estadoOrden) {
        appendChange(new EstadoOrdenDeTallerCambiado(estadoOrden)).apply();
    }

    public void agregarRepuestoALaOrdenDeTaller(RepuestoId repuestoId) {
        appendChange(new RepuestoAgregadoALaOrdenDeTaller(repuestoId)).apply();
    }

    public void cambiarNombreDelTecnico(TecnicoId tecnicoId, Nombre nombre) {
        appendChange(new NombreDelTecnicoCambiado(tecnicoId, nombre)).apply();
    }

    public void cambiarEspecialidadDelTecnico(TecnicoId tecnicoId, Especialidad especialidad) {
        appendChange(new EspecialidadDelTecnicoCambiada(tecnicoId, especialidad)).apply();
    }

    public void actualizarTemparioDeLaOperacion(OperacionId operacionId, Tempario tempario) {
        appendChange(new TemparioDeLaOperacionActualizado(operacionId, tempario)).apply();
    }

    public void cambiarCategoriaDeLaOperacion(OperacionId operacionId, Categoria categoria) {
        appendChange(new CategoriaDeLaOperacionCambiada(operacionId, categoria)).apply();
    }

    public void actualizarValorDeLaOperacion(OperacionId operacionId, Valor valor) {
        appendChange(new ValorDeLaOperacionActualizado(operacionId, valor)).apply();
    }

    public void actualizarEstadoDelTecnico(TecnicoId tecnicoId, EstadoTecnico estadoTecnico) {
        appendChange(new EstadoDelTecnicoActualizado(tecnicoId, estadoTecnico)).apply();
    }
}

package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;
import co.com.sofka.reto.ordentaller.values.Tempario;

public class OrdenDeTallerAbierta extends DomainEvent {
    private final TecnicoId tecnicoId;
    private final EstadoTecnico estadoTecnico;
    private final Nombre nombre;
    private final Especialidad especialidad;
    private final OperacionId operacionId;
    private final Tempario tempario;
    private final Categoria categoria;
    private final Valor valor;
    private final ClienteId clienteId;

    public OrdenDeTallerAbierta(TecnicoId tecnicoId, EstadoTecnico estadoTecnico, Nombre nombre, Especialidad especialidad, OperacionId operacionId, Tempario tempario, Categoria categoria, Valor valor, ClienteId clienteId) {
        super("reto.ordentaller.ordendetallerabierta");
        this.tecnicoId = tecnicoId;
        this.estadoTecnico = estadoTecnico;
        this.nombre = nombre;
        this.especialidad = especialidad;
        this.operacionId = operacionId;
        this.tempario = tempario;
        this.categoria = categoria;
        this.valor = valor;
        this.clienteId = clienteId;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public EstadoTecnico getEstadoTecnico() {
        return estadoTecnico;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Tempario getTempario() {
        return tempario;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public Valor getValor() {
        return valor;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}

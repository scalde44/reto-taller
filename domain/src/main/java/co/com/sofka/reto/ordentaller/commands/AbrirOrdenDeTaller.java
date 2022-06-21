package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.ordentaller.OperacionFactory;
import co.com.sofka.reto.ordentaller.TecnicoFactory;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;

public class AbrirOrdenDeTaller extends Command {
    private final OrdenTallerId ordenTallerId;
    private final TecnicoFactory tecnicoFactory;
    private final OperacionFactory operacionFactory;
    private final ClienteId clienteId;

    public AbrirOrdenDeTaller(OrdenTallerId ordenTallerId, TecnicoFactory tecnicoFactory, OperacionFactory operacionFactory, ClienteId clienteId) {
        this.ordenTallerId = ordenTallerId;
        this.tecnicoFactory = tecnicoFactory;
        this.operacionFactory = operacionFactory;
        this.clienteId = clienteId;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public TecnicoFactory getTecnicoFactory() {
        return tecnicoFactory;
    }

    public OperacionFactory getOperacionFactory() {
        return operacionFactory;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }
}

package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.values.TipoCliente;

public class CambiarTipoDeCliente extends Command {
    private final ClienteId clienteId;
    private final TipoCliente tipoCliente;

    public CambiarTipoDeCliente(ClienteId clienteId, TipoCliente tipoCliente) {
        this.clienteId = clienteId;
        this.tipoCliente = tipoCliente;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}

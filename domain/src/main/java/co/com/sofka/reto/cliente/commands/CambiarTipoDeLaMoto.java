package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.TipoMoto;

public class CambiarTipoDeLaMoto extends Command {
    private final ClienteId clienteId;
    private final Placa placa;
    private final TipoMoto tipoMoto;

    public CambiarTipoDeLaMoto(ClienteId clienteId, Placa placa, TipoMoto tipoMoto) {
        this.clienteId = clienteId;
        this.placa = placa;
        this.tipoMoto = tipoMoto;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Placa getPlaca() {
        return placa;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
}

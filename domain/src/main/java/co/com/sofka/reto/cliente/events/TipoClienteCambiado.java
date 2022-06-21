package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.values.TipoCliente;

public class TipoClienteCambiado extends DomainEvent {
    private final TipoCliente tipoCliente;

    public TipoClienteCambiado(TipoCliente tipoCliente) {
        super("reto.cliente.tipoclientecambiado");
        this.tipoCliente = tipoCliente;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}

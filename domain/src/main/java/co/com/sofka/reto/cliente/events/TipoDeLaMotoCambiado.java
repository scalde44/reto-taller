package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.TipoMoto;

public class TipoDeLaMotoCambiado extends DomainEvent {
    private final Placa placa;
    private final TipoMoto tipoMoto;

    public TipoDeLaMotoCambiado(Placa placa, TipoMoto tipoMoto) {
        super("reto.cliente.tipodelamotocambiado");
        this.placa = placa;
        this.tipoMoto = tipoMoto;
    }

    public Placa getPlaca() {
        return placa;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }
}

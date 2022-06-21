package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Vin;

public class VinDeLaMotoCambiado extends DomainEvent {
    private final Placa placa;
    private final Vin vin;

    public VinDeLaMotoCambiado(Placa placa, Vin vin) {
        super("reto.cliente.vindelamotocambiado");
        this.placa = placa;
        this.vin = vin;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Vin getVin() {
        return vin;
    }
}

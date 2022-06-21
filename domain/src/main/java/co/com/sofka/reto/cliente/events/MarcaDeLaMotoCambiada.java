package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Marca;

public class MarcaDeLaMotoCambiada extends DomainEvent {
    private final Placa placa;
    private final Marca marca;

    public MarcaDeLaMotoCambiada(Placa placa, Marca marca) {
        super("reto.cliente.marcadelamotocambiada");
        this.placa = placa;
        this.marca = marca;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Marca getMarca() {
        return marca;
    }
}

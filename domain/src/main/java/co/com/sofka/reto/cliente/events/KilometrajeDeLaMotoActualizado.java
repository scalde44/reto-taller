package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Kilometraje;

public class KilometrajeDeLaMotoActualizado extends DomainEvent {
    private final Placa placa;
    private final Kilometraje kilometraje;

    public KilometrajeDeLaMotoActualizado(Placa placa, Kilometraje kilometraje) {
        super("reto.cliente.kilometrajedelamotoactualizado");
        this.placa = placa;
        this.kilometraje = kilometraje;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Kilometraje getKilometraje() {
        return kilometraje;
    }
}

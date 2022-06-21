package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;

public class NombreDelTecnicoCambiado extends DomainEvent {
    private final TecnicoId tecnicoId;
    private final Nombre nombre;

    public NombreDelTecnicoCambiado(TecnicoId tecnicoId, Nombre nombre) {
        super("reto.ordentaller.nombredeltecnicocambiado");
        this.tecnicoId = tecnicoId;
        this.nombre = nombre;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

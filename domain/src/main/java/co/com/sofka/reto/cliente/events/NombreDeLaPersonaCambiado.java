package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.generic.values.Nombre;

public class NombreDeLaPersonaCambiado extends DomainEvent {
    private final PersonaId personaId;
    private final Nombre nombre;

    public NombreDeLaPersonaCambiado(PersonaId personaId, Nombre nombre) {
        super("reto.cliente.nombredelapersonacambiado");
        this.personaId = personaId;
        this.nombre = nombre;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

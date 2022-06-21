package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.generic.values.Nombre;

public class CambiarNombreDeLaPersona extends Command {
    private final ClienteId clienteId;
    private final PersonaId personaId;
    private final Nombre nombre;

    public CambiarNombreDeLaPersona(ClienteId clienteId, PersonaId personaId, Nombre nombre) {
        this.clienteId = clienteId;
        this.personaId = personaId;
        this.nombre = nombre;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

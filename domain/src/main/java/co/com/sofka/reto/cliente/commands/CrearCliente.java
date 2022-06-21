package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.MotoFactory;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.cliente.values.TipoCliente;
import co.com.sofka.reto.generic.values.Nombre;

public class CrearCliente extends Command {
    private final PersonaId personaId;
    private final Nombre nombre;
    private final MotoFactory motoFactory;
    private final TipoCliente tipoCliente;

    public CrearCliente(PersonaId personaId, Nombre nombre, MotoFactory motoFactory, TipoCliente tipoCliente) {
        this.personaId = personaId;
        this.nombre = nombre;
        this.motoFactory = motoFactory;
        this.tipoCliente = tipoCliente;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public MotoFactory getMotoFactory() {
        return motoFactory;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}

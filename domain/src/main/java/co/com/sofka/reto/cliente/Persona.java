package co.com.sofka.reto.cliente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.generic.values.Nombre;

import java.util.Objects;

public class Persona extends Entity<PersonaId> {
    private Nombre nombre;

    public Persona(PersonaId personaId, Nombre nombre) {
        super(personaId);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public Nombre nombre() {
        return nombre;
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }
}

package co.com.sofka.reto.cliente.identities;

import co.com.sofka.domain.generic.Identity;

public class PersonaId extends Identity {
    private PersonaId(String id) {
        super(id);
    }

    public PersonaId() {
    }

    public static PersonaId of(String id) {
        return new PersonaId(id);
    }
}

package co.com.sofka.reto.cliente.identities;

import co.com.sofka.domain.generic.Identity;

public class ClienteId extends Identity {
    private ClienteId(String id) {
        super(id);
    }

    public ClienteId() {
    }

    public static ClienteId of(String id) {
        return new ClienteId(id);
    }
}

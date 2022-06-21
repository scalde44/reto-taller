package co.com.sofka.reto.ordentaller.identities;

import co.com.sofka.domain.generic.Identity;

public class OperacionId extends Identity {
    private OperacionId(String id) {
        super(id);
    }

    public OperacionId() {
    }

    public static OperacionId of(String id) {
        return new OperacionId(id);
    }
}

package co.com.sofka.reto.ordentaller.identities;

import co.com.sofka.domain.generic.Identity;

public class OrdenTallerId extends Identity {
    private OrdenTallerId(String id) {
        super(id);
    }

    public OrdenTallerId() {
    }

    public static OrdenTallerId of(String id) {
        return new OrdenTallerId(id);
    }
}

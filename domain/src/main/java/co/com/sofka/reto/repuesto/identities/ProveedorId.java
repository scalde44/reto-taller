package co.com.sofka.reto.repuesto.identities;

import co.com.sofka.domain.generic.Identity;

public class ProveedorId extends Identity {
    private ProveedorId(String id) {
        super(id);
    }

    public ProveedorId() {
    }

    public static ProveedorId of(String id) {
        return new ProveedorId(id);
    }
}

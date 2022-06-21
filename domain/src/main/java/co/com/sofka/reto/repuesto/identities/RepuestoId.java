package co.com.sofka.reto.repuesto.identities;

import co.com.sofka.domain.generic.Identity;

public class RepuestoId extends Identity {
    private RepuestoId(String id) {
        super(id);
    }

    public RepuestoId() {
    }

    public static RepuestoId of(String id) {
        return new RepuestoId(id);
    }
}

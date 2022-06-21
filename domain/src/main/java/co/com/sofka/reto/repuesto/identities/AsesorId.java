package co.com.sofka.reto.repuesto.identities;

import co.com.sofka.domain.generic.Identity;

public class AsesorId extends Identity {
    private AsesorId(String id) {
        super(id);
    }

    public AsesorId() {
    }

    public static AsesorId of(String id) {
        return new AsesorId(id);
    }
}

package co.com.sofka.reto.ubicacion.identities;

import co.com.sofka.domain.generic.Identity;

public class EspacioId extends Identity {

    public EspacioId() {
    }

    private EspacioId(String id) {
        super(id);
    }

    public static EspacioId of(String id) {
        return new EspacioId(id);
    }
}

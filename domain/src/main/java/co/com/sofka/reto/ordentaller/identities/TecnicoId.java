package co.com.sofka.reto.ordentaller.identities;

import co.com.sofka.domain.generic.Identity;

public class TecnicoId extends Identity {
    private TecnicoId(String id) {
        super(id);
    }

    public TecnicoId() {
    }

    public static TecnicoId of(String id) {
        return new TecnicoId(id);
    }
}

package co.com.sofka.reto.ubicacion.identities;

import co.com.sofka.domain.generic.Identity;

public class UbicacionId extends Identity {

    public UbicacionId() {
    }

    private UbicacionId(String id) {
        super(id);
    }

    public static UbicacionId of(String id) {
        return new UbicacionId(id);
    }


}
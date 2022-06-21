package co.com.sofka.reto.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;
import co.com.sofka.reto.ubicacion.values.Direccion;

public class CambiarDireccionDelEspacio extends Command {

    private final UbicacionId ubicacionId;
    private final EspacioId espacioId;
    private final Direccion direccion;

    public CambiarDireccionDelEspacio(UbicacionId ubicacionId, EspacioId espacioId, Direccion direccion) {
        this.ubicacionId = ubicacionId;
        this.espacioId = espacioId;
        this.direccion = direccion;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Direccion getDireccion() {
        return direccion;
    }
}

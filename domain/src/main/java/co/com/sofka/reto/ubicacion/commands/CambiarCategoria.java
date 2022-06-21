package co.com.sofka.reto.ubicacion.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;
import co.com.sofka.reto.ubicacion.values.Categoria;

public class CambiarCategoria extends Command {

    private final UbicacionId ubicacionId;
    private final Categoria categoria;

    public CambiarCategoria(UbicacionId ubicacionId, Categoria categoria) {
        this.ubicacionId = ubicacionId;
        this.categoria = categoria;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

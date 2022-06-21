package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;

public class CambiarNombreDelTecnico extends Command {
    private final OrdenTallerId ordenTallerId;
    private final TecnicoId tecnicoId;
    private final Nombre nombre;

    public CambiarNombreDelTecnico(OrdenTallerId ordenTallerId, TecnicoId tecnicoId, Nombre nombre) {
        this.ordenTallerId = ordenTallerId;
        this.tecnicoId = tecnicoId;
        this.nombre = nombre;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public Nombre getNombre() {
        return nombre;
    }
}

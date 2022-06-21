package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.Especialidad;

public class CambiarEspecialidadDelTecnico extends Command {
    private final OrdenTallerId ordenTallerId;
    private final TecnicoId tecnicoId;
    private final Especialidad especialidad;

    public CambiarEspecialidadDelTecnico(OrdenTallerId ordenTallerId, TecnicoId tecnicoId, Especialidad especialidad) {
        this.ordenTallerId = ordenTallerId;
        this.tecnicoId = tecnicoId;
        this.especialidad = especialidad;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}

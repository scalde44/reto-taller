package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.Especialidad;

public class EspecialidadDelTecnicoCambiada extends DomainEvent {
    private final TecnicoId tecnicoId;
    private final Especialidad especialidad;

    public EspecialidadDelTecnicoCambiada(TecnicoId tecnicoId, Especialidad especialidad) {
        super("reto.ordentaller.especialidaddeltecnicocambiada");
        this.tecnicoId = tecnicoId;
        this.especialidad = especialidad;
    }

    public TecnicoId getTecnicoId() {
        return tecnicoId;
    }

    public Especialidad getEspecialidad() {
        return especialidad;
    }
}

package co.com.sofka.reto.ordentaller;

import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;

import java.util.Objects;

public class TecnicoFactory {
    private Tecnico tecnico;
    private static TecnicoFactory instance;

    private TecnicoFactory() {
    }

    public static TecnicoFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new TecnicoFactory();
            return instance;
        }
        return instance;
    }

    public TecnicoFactory crear(TecnicoId tecnicoId, EstadoTecnico estadoTecnico, Nombre nombre, Especialidad especialidad) {
        this.tecnico = new Tecnico(tecnicoId, estadoTecnico, especialidad, nombre);
        return this;
    }

    protected Tecnico tecnico() {
        return tecnico;
    }
}

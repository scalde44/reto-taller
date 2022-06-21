package co.com.sofka.reto.ordentaller;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;

import java.util.Objects;

public class Tecnico extends Entity<TecnicoId> {
    private EstadoTecnico estadoTecnico;
    private Especialidad especialidad;
    private Nombre nombre;

    public Tecnico(TecnicoId tecnicoId, EstadoTecnico estadoTecnico, Especialidad especialidad, Nombre nombre) {
        super(tecnicoId);
        this.estadoTecnico = Objects.requireNonNull(estadoTecnico);
        this.especialidad = Objects.requireNonNull(especialidad);
        this.nombre = Objects.requireNonNull(nombre);
    }

    public EstadoTecnico estadoTecnico() {
        return estadoTecnico;
    }

    public Especialidad especialidad() {
        return especialidad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public void actualizarEstado(EstadoTecnico estadoTecnico) {
        this.estadoTecnico = Objects.requireNonNull(estadoTecnico);
    }

    public void cambiarEspecialidad(Especialidad especialidad) {
        this.especialidad = Objects.requireNonNull(especialidad);
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = Objects.requireNonNull(nombre);
    }
}

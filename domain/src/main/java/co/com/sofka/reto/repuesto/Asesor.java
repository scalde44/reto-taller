package co.com.sofka.reto.repuesto;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.values.Antiguedad;

public class Asesor extends Entity<AsesorId> {
    private Nombre nombre;
    private Antiguedad antiguedad;

    public Asesor(AsesorId asesorId, Nombre nombre, Antiguedad antiguedad) {
        super(asesorId);
        this.nombre = nombre;
        this.antiguedad = antiguedad;
    }

    public Nombre nombre() {
        return nombre;
    }

    public Antiguedad antiguedad() {
        return antiguedad;
    }

    public void cambiarNombre(Nombre nombre) {
        this.nombre = nombre;
    }

    public void actualizarAntiguedad(Antiguedad antiguedad) {
        this.antiguedad = antiguedad;
    }
}

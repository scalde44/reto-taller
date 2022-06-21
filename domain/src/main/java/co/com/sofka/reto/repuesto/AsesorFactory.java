package co.com.sofka.reto.repuesto;

import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.values.Antiguedad;

import java.util.Objects;

public class AsesorFactory {
    private Asesor asesor;
    private static AsesorFactory instance;

    private AsesorFactory() {
    }

    public static AsesorFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new AsesorFactory();
            return instance;
        }
        return instance;
    }

    public AsesorFactory crear(AsesorId asesorId, Nombre nombre, Antiguedad antiguedad) {
        this.asesor = new Asesor(asesorId, nombre, antiguedad);
        return this;
    }

    protected Asesor asesor() {
        return this.asesor;
    }
}

package co.com.sofka.reto.ubicacion;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.values.Direccion;
import co.com.sofka.reto.ubicacion.values.Estado;

public class Espacio extends Entity<EspacioId> {

    private Estado estado;
    private Direccion direccion;

    public Espacio(EspacioId espacioId, Direccion direccion) {
        super(espacioId);
        this.direccion = direccion;
    }

    public Estado estado() {
        return estado;
    }

    public Direccion direccion() {
        return direccion;
    }

    public void actualizarEstado(Estado estado) {
        this.estado = estado;
    }

    public void cambiarDireccion(Direccion direccion) {
        this.direccion = direccion;
    }

}
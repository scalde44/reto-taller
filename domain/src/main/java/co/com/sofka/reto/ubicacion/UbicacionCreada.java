package co.com.sofka.reto.ubicacion;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.values.Categoria;
import co.com.sofka.reto.ubicacion.values.Direccion;
import co.com.sofka.reto.ubicacion.values.Estado;

public class UbicacionCreada extends DomainEvent {
    private final EspacioId espacioId;
    private final Estado estado;
    private final Direccion direccion;
    private final Categoria categoria;

    public UbicacionCreada(EspacioId espacioId, Estado estado, Direccion direccion, Categoria categoria) {
        super("reto.ubicacion.ubicacioncreada");
        this.espacioId = espacioId;
        this.estado = estado;
        this.direccion = direccion;
        this.categoria = categoria;
    }

    public EspacioId getEspacioId() {
        return espacioId;
    }

    public Estado getEstado() {
        return estado;
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

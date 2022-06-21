package co.com.sofka.reto.ubicacion;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ubicacion.events.CategoriaCambiada;
import co.com.sofka.reto.ubicacion.events.DireccionDelEspacioCambiada;
import co.com.sofka.reto.ubicacion.events.EstadoDelEspacioActualizado;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;
import co.com.sofka.reto.ubicacion.values.Categoria;
import co.com.sofka.reto.ubicacion.values.Direccion;
import co.com.sofka.reto.ubicacion.values.Estado;

import java.util.List;

public class Ubicacion extends AggregateEvent<UbicacionId> {
    protected Espacio espacio;
    protected Categoria categoria;

    public Ubicacion(UbicacionId id, EspacioId espacioId, Estado estado, Direccion direccion, Categoria categoria) {
        super(id);
        subscribe(new UbicacionChange(this));
        appendChange(new UbicacionCreada(espacioId, estado, direccion, categoria)).apply();
    }

    private Ubicacion(UbicacionId id) {
        super(id);
        subscribe(new UbicacionChange(this));
    }

    public static Ubicacion from(UbicacionId ubicacionId, List<DomainEvent> events) {
        var ubicacion = new Ubicacion(ubicacionId);
        events.forEach(ubicacion::applyEvent);
        return ubicacion;
    }

    public void cambiarCategoria(Categoria categoria) {
        appendChange(new CategoriaCambiada(categoria)).apply();
    }

    public void actualizarEstadoDelEspacio(EspacioId espacioId, Estado estado) {
        appendChange(new EstadoDelEspacioActualizado(espacioId, estado)).apply();
    }

    public void cambiarDireccionDelEspacio(EspacioId espacioId, Direccion direccion) {
        appendChange(new DireccionDelEspacioCambiada(espacioId, direccion)).apply();
    }
}

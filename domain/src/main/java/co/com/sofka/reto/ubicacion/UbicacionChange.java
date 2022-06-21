package co.com.sofka.reto.ubicacion;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.ubicacion.events.CategoriaCambiada;
import co.com.sofka.reto.ubicacion.events.DireccionDelEspacioCambiada;
import co.com.sofka.reto.ubicacion.events.EstadoDelEspacioActualizado;

public class UbicacionChange extends EventChange {
    public UbicacionChange(Ubicacion ubicacion) {
        apply((UbicacionCreada event) -> {
            ubicacion.espacio = new Espacio(event.getEspacioId(), event.getDireccion());
            ubicacion.categoria = event.getCategoria();
        });

        apply((CategoriaCambiada event) -> {
            ubicacion.categoria = event.getCategoria();
        });

        apply((EstadoDelEspacioActualizado event) -> {
            if (!ubicacion.espacio.identity().equals(event.getEspacioId())) {
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            ubicacion.espacio.actualizarEstado(event.getEstado());
        });

        apply((DireccionDelEspacioCambiada event) -> {
            if (!ubicacion.espacio.identity().equals(event.getEspacioId())) {
                throw new IllegalArgumentException("No tiene la identidad correcta");
            }
            ubicacion.espacio.cambiarDireccion(event.getDireccion());
        });
    }
}

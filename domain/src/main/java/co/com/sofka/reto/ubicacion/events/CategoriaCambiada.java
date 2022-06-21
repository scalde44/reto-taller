package co.com.sofka.reto.ubicacion.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ubicacion.values.Categoria;

public class CategoriaCambiada extends DomainEvent {
    private final Categoria categoria;

    public CategoriaCambiada(Categoria categoria) {
        super("reto.ubicacion.categoriacambiada");
        this.categoria = categoria;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

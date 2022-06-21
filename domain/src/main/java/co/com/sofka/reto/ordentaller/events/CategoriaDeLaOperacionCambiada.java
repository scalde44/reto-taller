package co.com.sofka.reto.ordentaller.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.values.Categoria;

public class CategoriaDeLaOperacionCambiada extends DomainEvent {
    private final OperacionId operacionId;
    private final Categoria categoria;

    public CategoriaDeLaOperacionCambiada(OperacionId operacionId, Categoria categoria) {
        super("reto.ordentaller.categoriadelaoperacioncambiada");
        this.operacionId = operacionId;
        this.categoria = categoria;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

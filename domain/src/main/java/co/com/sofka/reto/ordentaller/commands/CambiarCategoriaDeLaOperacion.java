package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.values.Categoria;

public class CambiarCategoriaDeLaOperacion extends Command {
    private final OrdenTallerId ordenTallerId;
    private final OperacionId operacionId;
    private final Categoria categoria;

    public CambiarCategoriaDeLaOperacion(OrdenTallerId ordenTallerId, OperacionId operacionId, Categoria categoria) {
        this.ordenTallerId = ordenTallerId;
        this.operacionId = operacionId;
        this.categoria = categoria;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Categoria getCategoria() {
        return categoria;
    }
}

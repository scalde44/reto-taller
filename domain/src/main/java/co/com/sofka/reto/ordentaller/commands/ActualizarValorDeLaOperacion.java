package co.com.sofka.reto.ordentaller.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;

public class ActualizarValorDeLaOperacion extends Command {
    private final OrdenTallerId ordenTallerId;
    private final OperacionId operacionId;
    private final Valor valor;

    public ActualizarValorDeLaOperacion(OrdenTallerId ordenTallerId, OperacionId operacionId, Valor valor) {
        this.ordenTallerId = ordenTallerId;
        this.operacionId = operacionId;
        this.valor = valor;
    }

    public OrdenTallerId getOrdenTallerId() {
        return ordenTallerId;
    }

    public OperacionId getOperacionId() {
        return operacionId;
    }

    public Valor getValor() {
        return valor;
    }
}

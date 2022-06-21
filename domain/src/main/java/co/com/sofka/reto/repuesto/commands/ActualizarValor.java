package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

public class ActualizarValor extends Command {
    private final RepuestoId repuestoId;
    private final Valor valor;

    public ActualizarValor(RepuestoId repuestoId, Valor valor) {
        this.repuestoId = repuestoId;
        this.valor = valor;
    }

    public RepuestoId getRepuestoId() {
        return repuestoId;
    }

    public Valor getValor() {
        return valor;
    }
}

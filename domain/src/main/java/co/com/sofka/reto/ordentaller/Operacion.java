package co.com.sofka.reto.ordentaller;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Tempario;

import java.util.Objects;

public class Operacion extends Entity<OperacionId> {
    private Tempario tempario;
    private Categoria categoria;
    private Valor valor;

    public Operacion(OperacionId operacionId, Tempario tempario, Categoria categoria, Valor valor) {
        super(operacionId);
        this.tempario = Objects.requireNonNull(tempario);
        this.categoria = Objects.requireNonNull(categoria);
        this.valor = Objects.requireNonNull(valor);
    }

    public Tempario tempario() {
        return tempario;
    }

    public Categoria categoria() {
        return categoria;
    }

    public Valor valor() {
        return valor;
    }

    public void actualizarTempario(Tempario tempario) {
        this.tempario = Objects.requireNonNull(tempario);
    }

    public void cambiarCategoria(Categoria categoria) {
        this.categoria = Objects.requireNonNull(categoria);
    }

    public void actualizarValor(Valor valor) {
        this.valor = Objects.requireNonNull(valor);
    }
}

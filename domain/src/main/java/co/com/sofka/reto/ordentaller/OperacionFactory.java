package co.com.sofka.reto.ordentaller;

import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Tempario;

import java.util.Objects;

public class OperacionFactory {
    private Operacion operacion;
    private static OperacionFactory instance;

    private OperacionFactory() {
    }

    public static OperacionFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new OperacionFactory();
            return instance;
        }
        return instance;
    }

    public OperacionFactory crear(OperacionId operacionId, Tempario tempario, Categoria categoria, Valor valor) {
        this.operacion = new Operacion(operacionId, tempario, categoria, valor);
        return this;
    }

    protected Operacion operacion() {
        return operacion;
    }
}

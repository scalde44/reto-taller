package co.com.sofka.reto.cliente;

import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.*;

import java.util.Objects;

public class MotoFactory {
    private Moto moto;
    private static MotoFactory instance;

    private MotoFactory() {
    }

    public static MotoFactory getInstance() {
        if (Objects.isNull(instance)) {
            instance = new MotoFactory();
            return instance;
        }
        return instance;
    }

    public MotoFactory crear(Placa placa, Vin vin, Motor motor, Marca marca, Kilometraje kilometraje, TipoMoto tipoMoto) {
        this.moto = new Moto(placa, vin, motor, marca, kilometraje, tipoMoto);
        return this;
    }

    protected Moto moto() {
        return this.moto;
    }
}

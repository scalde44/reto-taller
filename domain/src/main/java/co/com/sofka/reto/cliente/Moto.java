package co.com.sofka.reto.cliente;

import co.com.sofka.domain.generic.Entity;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.*;

import java.util.Objects;

public class Moto extends Entity<Placa> {
    private Vin vin;
    private Motor motor;
    private Marca marca;
    private Kilometraje kilometraje;
    private TipoMoto tipoMoto;

    public Moto(Placa placa, Vin vin, Motor motor, Marca marca, Kilometraje kilometraje, TipoMoto tipoMoto) {
        super(placa);
        this.vin = Objects.requireNonNull(vin);
        this.motor = Objects.requireNonNull(motor);
        this.marca = Objects.requireNonNull(marca);
        this.kilometraje = Objects.requireNonNull(kilometraje);
        this.tipoMoto = Objects.requireNonNull(tipoMoto);
    }

    public Vin vin() {
        return vin;
    }

    public Motor motor() {
        return motor;
    }

    public Marca marca() {
        return marca;
    }

    public Kilometraje kilometraje() {
        return kilometraje;
    }

    public TipoMoto tipoMoto() {
        return tipoMoto;
    }

    public void cambiarVin(Vin vin) {
        this.vin = Objects.requireNonNull(vin);
    }

    public void actualizarMotor(Motor motor) {
        this.motor = Objects.requireNonNull(motor);
    }

    public void cambiarMarca(Marca marca) {
        this.marca = Objects.requireNonNull(marca);
    }

    public void actualizarKilometraje(Kilometraje kilometraje) {
        this.kilometraje = Objects.requireNonNull(kilometraje);
    }

    public void cambiarTipoMoto(TipoMoto tipoMoto) {
        this.tipoMoto = Objects.requireNonNull(tipoMoto);
    }
}

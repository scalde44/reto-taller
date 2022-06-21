package co.com.sofka.reto.cliente.events;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Motor;

public class MotorDeLaMotoActualizado extends DomainEvent {
    private final Placa placa;
    private final Motor motor;

    public MotorDeLaMotoActualizado(Placa placa, Motor motor) {
        super("reto.cliente.motordelamotoactualizado");
        this.placa = placa;
        this.motor = motor;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Motor getMotor() {
        return motor;
    }
}

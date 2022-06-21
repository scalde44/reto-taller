package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Motor;

public class ActualizarMotorDeLaMoto extends Command {
    private final ClienteId clienteId;
    private final Placa placa;
    private final Motor motor;

    public ActualizarMotorDeLaMoto(ClienteId clienteId, Placa placa, Motor motor) {
        this.clienteId = clienteId;
        this.placa = placa;
        this.motor = motor;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Motor getMotor() {
        return motor;
    }
}

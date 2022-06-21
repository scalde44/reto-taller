package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Kilometraje;

public class ActualizarKilometrajeDeLaMoto extends Command {
    private final ClienteId clienteId;
    private final Placa placa;
    private final Kilometraje kilometraje;

    public ActualizarKilometrajeDeLaMoto(ClienteId clienteId, Placa placa, Kilometraje kilometraje) {
        this.clienteId = clienteId;
        this.placa = placa;
        this.kilometraje = kilometraje;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Kilometraje getKilometraje() {
        return kilometraje;
    }
}

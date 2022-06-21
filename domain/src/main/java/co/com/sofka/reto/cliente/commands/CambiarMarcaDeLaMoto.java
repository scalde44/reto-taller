package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Marca;

public class CambiarMarcaDeLaMoto extends Command {
    private final ClienteId clienteId;
    private final Placa placa;
    private final Marca marca;

    public CambiarMarcaDeLaMoto(ClienteId clienteId, Placa placa, Marca marca) {
        this.clienteId = clienteId;
        this.placa = placa;
        this.marca = marca;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Marca getMarca() {
        return marca;
    }
}

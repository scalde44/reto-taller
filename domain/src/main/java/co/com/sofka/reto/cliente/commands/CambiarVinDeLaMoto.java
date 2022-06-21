package co.com.sofka.reto.cliente.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.Vin;

public class CambiarVinDeLaMoto extends Command {
    private final ClienteId clienteId;
    private final Placa placa;
    private final Vin vin;

    public CambiarVinDeLaMoto(ClienteId clienteId, Placa placa, Vin vin) {
        this.clienteId = clienteId;
        this.placa = placa;
        this.vin = vin;
    }

    public ClienteId getClienteId() {
        return clienteId;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Vin getVin() {
        return vin;
    }
}

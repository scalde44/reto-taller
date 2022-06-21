package co.com.sofka.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.cliente.Cliente;
import co.com.sofka.reto.cliente.commands.CrearCliente;
import co.com.sofka.reto.cliente.identities.ClienteId;

public class CrearClienteUseCase extends UseCase<RequestCommand<CrearCliente>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearCliente> input) {
        var command = input.getCommand();
        var cliente = new Cliente(new ClienteId(), command.getPersonaId(), command.getNombre(), command.getMotoFactory(), command.getTipoCliente());
        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}

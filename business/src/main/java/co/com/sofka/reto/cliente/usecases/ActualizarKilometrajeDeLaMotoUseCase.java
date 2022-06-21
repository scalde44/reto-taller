package co.com.sofka.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.cliente.Cliente;
import co.com.sofka.reto.cliente.commands.ActualizarKilometrajeDeLaMoto;

public class ActualizarKilometrajeDeLaMotoUseCase extends UseCase<RequestCommand<ActualizarKilometrajeDeLaMoto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarKilometrajeDeLaMoto> input) {
        var command = input.getCommand();
        var cliente = Cliente.from(command.getClienteId(), repository().getEventsBy(command.getClienteId().value()));

        cliente.actualizarKilometrajeDeLaMoto(command.getPlaca(), command.getKilometraje());

        emit().onResponse(new ResponseEvents(cliente.getUncommittedChanges()));
    }
}

package co.com.sofka.reto.ordentaller;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.ordentaller.commands.AbrirOrdenDeTaller;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;

public class AbrirOrdenDeTallerUseCase extends UseCase<RequestCommand<AbrirOrdenDeTaller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AbrirOrdenDeTaller> input) {
        var command = input.getCommand();
        var ordenTaller = new OrdenTaller(new OrdenTallerId(), command.getTecnicoFactory(), command.getOperacionFactory(), command.getClienteId());
        emit().onResponse(new ResponseEvents(ordenTaller.getUncommittedChanges()));
    }
}

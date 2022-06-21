package co.com.sofka.reto.ordentaller;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.ordentaller.commands.AgregarRepuestoALaOrdenDeTaller;

public class AgregarRepuestoALaOrdenDeTallerUseCase extends UseCase<RequestCommand<AgregarRepuestoALaOrdenDeTaller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AgregarRepuestoALaOrdenDeTaller> input) {
        var command = input.getCommand();
        var ordenTaller = OrdenTaller.from(command.getOrdenTallerId(), repository().getEventsBy(command.getOrdenTallerId().value()));

        ordenTaller.agregarRepuestoALaOrdenDeTaller(command.getRepuestoId());

        emit().onResponse(new ResponseEvents(ordenTaller.getUncommittedChanges()));
    }
}

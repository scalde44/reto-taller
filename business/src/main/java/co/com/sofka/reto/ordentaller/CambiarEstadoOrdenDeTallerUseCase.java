package co.com.sofka.reto.ordentaller;


import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.ordentaller.commands.CambiarEstadoOrdenDeTaller;

public class CambiarEstadoOrdenDeTallerUseCase extends UseCase<RequestCommand<CambiarEstadoOrdenDeTaller>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarEstadoOrdenDeTaller> input) {
        var command = input.getCommand();
        var ordenTaller = OrdenTaller.from(command.getOrdenTallerId(), repository().getEventsBy(command.getOrdenTallerId().value()));

        ordenTaller.cambiarEstadoOrdenDeTaller(command.getEstadoOrden());

        emit().onResponse(new ResponseEvents(ordenTaller.getUncommittedChanges()));
    }
}

package co.com.sofka.reto.ordentaller.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.ordentaller.OrdenTaller;
import co.com.sofka.reto.ordentaller.commands.ActualizarEstadoDelTecnico;

public class ActualizarEstadoDelTecnicoUseCase extends UseCase<RequestCommand<ActualizarEstadoDelTecnico>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<ActualizarEstadoDelTecnico> input) {
        var command = input.getCommand();
        var ordenTaller = OrdenTaller.from(command.getOrdenTallerId(), repository().getEventsBy(command.getOrdenTallerId().value()));

        ordenTaller.actualizarEstadoDelTecnico(command.getTecnicoId(), command.getEstadoTecnico());

        emit().onResponse(new ResponseEvents(ordenTaller.getUncommittedChanges()));
    }
}

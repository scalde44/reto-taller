package co.com.sofka.reto.ordentaller.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.ordentaller.OrdenTaller;
import co.com.sofka.reto.ordentaller.commands.CambiarCategoriaDeLaOperacion;

public class CambiarCategoriaDeLaOperacionUseCase extends UseCase<RequestCommand<CambiarCategoriaDeLaOperacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CambiarCategoriaDeLaOperacion> input) {
        var command = input.getCommand();
        var ordenTaller = OrdenTaller.from(command.getOrdenTallerId(), repository().getEventsBy(command.getOrdenTallerId().value()));

        ordenTaller.cambiarCategoriaDeLaOperacion(command.getOperacionId(), command.getCategoria());

        emit().onResponse(new ResponseEvents(ordenTaller.getUncommittedChanges()));
    }
}

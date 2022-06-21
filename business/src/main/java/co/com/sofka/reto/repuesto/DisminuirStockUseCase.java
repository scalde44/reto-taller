package co.com.sofka.reto.repuesto;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.repuesto.commands.DisminuirStock;

public class DisminuirStockUseCase extends UseCase<RequestCommand<DisminuirStock>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<DisminuirStock> input) {
        var command = input.getCommand();
        var repuesto = Repuesto.from(command.getRepuestoId(), repository().getEventsBy(command.getRepuestoId().value()));

        repuesto.disminuirStock(command.getStock());

        emit().onResponse(new ResponseEvents(repuesto.getUncommittedChanges()));
    }
}

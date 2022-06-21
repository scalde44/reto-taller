package co.com.sofka.reto.repuesto.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.repuesto.Repuesto;
import co.com.sofka.reto.repuesto.commands.AumentarStock;

public class AumentarStockUseCase extends UseCase<RequestCommand<AumentarStock>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<AumentarStock> input) {
        var command = input.getCommand();
        var repuesto = Repuesto.from(command.getRepuestoId(), repository().getEventsBy(command.getRepuestoId().value()));

        repuesto.aumentarStock(command.getStock());

        emit().onResponse(new ResponseEvents(repuesto.getUncommittedChanges()));
    }
}

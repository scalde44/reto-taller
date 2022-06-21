package co.com.sofka.reto.repuesto.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.ordentaller.events.RepuestoAgregadoALaOrdenDeTaller;
import co.com.sofka.reto.repuesto.Repuesto;
import co.com.sofka.reto.repuesto.values.Stock;

public class DisminuirStockUseCase extends UseCase<TriggeredEvent<RepuestoAgregadoALaOrdenDeTaller>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<RepuestoAgregadoALaOrdenDeTaller> input) {
        var event = input.getDomainEvent();
        var repuesto = Repuesto.from(event.getRepuestoId(), repository().getEventsBy(event.getRepuestoId().value()));

        repuesto.disminuirStock(new Stock(1));

        emit().onResponse(new ResponseEvents(repuesto.getUncommittedChanges()));
    }
}

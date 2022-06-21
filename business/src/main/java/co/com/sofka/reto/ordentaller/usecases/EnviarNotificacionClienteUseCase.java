package co.com.sofka.reto.ordentaller.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.ordentaller.events.OrdenDeTallerAbierta;
import co.com.sofka.reto.ordentaller.services.SenderNotification;

import java.util.List;

public class EnviarNotificacionClienteUseCase extends UseCase<TriggeredEvent<OrdenDeTallerAbierta>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<OrdenDeTallerAbierta> input) {
        var event = input.getDomainEvent();
        var service = getService(SenderNotification.class).orElseThrow();

        service.sendNotificacion(event.getClienteId(), "La orden de taller se encuentra abierta");

        emit().onResponse(new ResponseEvents(List.of()));
    }
}

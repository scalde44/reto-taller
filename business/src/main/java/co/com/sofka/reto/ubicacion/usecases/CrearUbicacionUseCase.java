package co.com.sofka.reto.ubicacion.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.ubicacion.Ubicacion;
import co.com.sofka.reto.ubicacion.commands.CrearUbicacion;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;

public class CrearUbicacionUseCase extends UseCase<RequestCommand<CrearUbicacion>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearUbicacion> input) {
        var command = input.getCommand();
        var ubicacion = new Ubicacion(new UbicacionId(), command.getEspacioId(), command.getEstado(), command.getDireccion(), command.getCategoria());
        emit().onResponse(new ResponseEvents(ubicacion.getUncommittedChanges()));
    }
}

package co.com.sofka.reto.repuesto.usecases;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.reto.repuesto.Repuesto;
import co.com.sofka.reto.repuesto.commands.CrearRepuesto;
import co.com.sofka.reto.repuesto.identities.RepuestoId;

public class CrearRepuestoUseCase extends UseCase<RequestCommand<CrearRepuesto>, ResponseEvents> {
    @Override
    public void executeUseCase(RequestCommand<CrearRepuesto> input) {
        var command = input.getCommand();
        var repuesto = new Repuesto(new RepuestoId(), command.getProveedorFactory(), command.getAsesorFactory(), command.getUbicacionId(), command.getStock(), command.getValor());
        emit().onResponse(new ResponseEvents(repuesto.getUncommittedChanges()));
    }
}

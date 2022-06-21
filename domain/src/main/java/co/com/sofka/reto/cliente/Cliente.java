package co.com.sofka.reto.cliente;

import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.events.*;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.*;
import co.com.sofka.reto.generic.values.Nombre;

import java.util.List;

public class Cliente extends AggregateEvent<ClienteId> {
    protected Persona persona;
    protected Moto moto;
    protected TipoCliente tipoCliente;

    public Cliente(ClienteId clienteId, PersonaId personaId, Nombre nombre, MotoFactory motoFactory, TipoCliente tipoCliente) {
        super(clienteId);
        subscribe(new ClienteChange(this));
        var moto = motoFactory.moto();
        appendChange(new ClienteCreado(personaId, nombre, moto.identity(), moto.vin(), moto.motor(), moto.marca(), moto.kilometraje(), moto.tipoMoto(), tipoCliente)).apply();
    }

    private Cliente(ClienteId clienteId) {
        super(clienteId);
        subscribe(new ClienteChange(this));
    }

    public static Cliente from(ClienteId clienteId, List<DomainEvent> eventsBy) {
        var cliente = new Cliente(clienteId);
        eventsBy.forEach(cliente::applyEvent);
        return cliente;
    }

    public void cambiarNombreDeLaPersona(PersonaId personaId, Nombre nombre) {
        appendChange(new NombreDeLaPersonaCambiado(personaId, nombre)).apply();
    }

    public void cambiarVinDeLaMoto(Placa placa, Vin vin) {
        appendChange(new VinDeLaMotoCambiado(placa, vin)).apply();
    }

    public void actualizarMotorDeLaMoto(Placa placa, Motor motor) {
        appendChange(new MotorDeLaMotoActualizado(placa, motor)).apply();
    }

    public void cambiarMarcaDeLaMoto(Placa placa, Marca marca) {
        appendChange(new MarcaDeLaMotoCambiada(placa, marca)).apply();
    }

    public void actualizarKilometrajeDeLaMoto(Placa placa, Kilometraje kilometraje) {
        appendChange(new KilometrajeDeLaMotoActualizado(placa, kilometraje)).apply();
    }

    public void cambiarTipoDeLaMoto(Placa placa, TipoMoto tipoMoto) {
        appendChange(new TipoDeLaMotoCambiado(placa, tipoMoto)).apply();
    }

    public void cambiarTipoCliente(TipoCliente tipoCliente) {
        appendChange(new TipoClienteCambiado(tipoCliente)).apply();
    }
}

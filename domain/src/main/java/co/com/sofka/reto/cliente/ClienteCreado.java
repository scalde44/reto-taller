package co.com.sofka.reto.cliente;

import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.*;
import co.com.sofka.reto.generic.values.Nombre;

public class ClienteCreado extends DomainEvent {
    private final PersonaId personaId;
    private final Nombre nombre;
    private final Placa placa;
    private final Vin vin;
    private final Motor motor;
    private final Marca marca;
    private final Kilometraje kilometraje;
    private final TipoMoto tipoMoto;
    private final TipoCliente tipoCliente;

    public ClienteCreado(PersonaId personaId, Nombre nombre, Placa placa, Vin vin, Motor motor, Marca marca, Kilometraje kilometraje, TipoMoto tipoMoto, TipoCliente tipoCliente) {
        super("reto.cliente.clientecreado");
        this.personaId = personaId;
        this.nombre = nombre;
        this.placa = placa;
        this.vin = vin;
        this.motor = motor;
        this.marca = marca;
        this.kilometraje = kilometraje;
        this.tipoMoto = tipoMoto;
        this.tipoCliente = tipoCliente;
    }

    public PersonaId getPersonaId() {
        return personaId;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public Placa getPlaca() {
        return placa;
    }

    public Vin getVin() {
        return vin;
    }

    public Motor getMotor() {
        return motor;
    }

    public Marca getMarca() {
        return marca;
    }

    public Kilometraje getKilometraje() {
        return kilometraje;
    }

    public TipoMoto getTipoMoto() {
        return tipoMoto;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
}

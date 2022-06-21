package co.com.sofka.reto.cliente;

import co.com.sofka.domain.generic.EventChange;
import co.com.sofka.reto.cliente.events.*;

public class ClienteChange extends EventChange {
    public ClienteChange(Cliente cliente) {
        apply((ClienteCreado event) -> {
            cliente.tipoCliente = event.getTipoCliente();
            cliente.moto = new Moto(event.getPlaca(), event.getVin(), event.getMotor(), event.getMarca(), event.getKilometraje(), event.getTipoMoto());
            cliente.persona = new Persona(event.getPersonaId(), event.getNombre());
        });
        apply((NombreDeLaPersonaCambiado event) -> {
            if (!cliente.persona.identity().equals(event.getPersonaId())) {
                throw new IllegalArgumentException("La persona no se encontro");
            }
            cliente.persona.cambiarNombre(event.getNombre());
        });
        apply((VinDeLaMotoCambiado event) -> {
            if (!cliente.moto.identity().equals(event.getPlaca())) {
                throw new IllegalArgumentException("La moto no se encontro");
            }
            cliente.moto.cambiarVin(event.getVin());
        });
        apply((MotorDeLaMotoActualizado event) -> {
            if (!cliente.moto.identity().equals(event.getPlaca())) {
                throw new IllegalArgumentException("La moto no se encontro");
            }
            cliente.moto.actualizarMotor(event.getMotor());
        });
        apply((MarcaDeLaMotoCambiada event) -> {
            if (!cliente.moto.identity().equals(event.getPlaca())) {
                throw new IllegalArgumentException("La moto no se encontro");
            }
            cliente.moto.cambiarMarca(event.getMarca());
        });
        apply((KilometrajeDeLaMotoActualizado event) -> {
            if (!cliente.moto.identity().equals(event.getPlaca())) {
                throw new IllegalArgumentException("La moto no se encontro");
            }
            cliente.moto.actualizarKilometraje(event.getKilometraje());
        });
        apply((TipoDeLaMotoCambiado event) -> {
            if (!cliente.moto.identity().equals(event.getPlaca())) {
                throw new IllegalArgumentException("La moto no se encontro");
            }
            cliente.moto.cambiarTipoMoto(event.getTipoMoto());
        });
        apply((TipoClienteCambiado event) -> {
            cliente.tipoCliente = event.getTipoCliente();
        });
    }
}

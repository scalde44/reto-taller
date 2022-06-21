package co.com.sofka.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.cliente.ClienteCreado;
import co.com.sofka.reto.cliente.MotoFactory;
import co.com.sofka.reto.cliente.commands.CrearCliente;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.*;
import co.com.sofka.reto.generic.values.Nombre;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CrearClienteUseCaseTest {
    @Test
    void crearCliente() {
        //arrange
        var personaId = PersonaId.of("10002353");
        var nombre = new Nombre("Steven");
        var motoFactory = MotoFactory.getInstance()
                .crear(Placa.from("ABC12S"), new Vin("4Y1SL65848Z411439"), new Motor(Motor.Motores.BICILINDRICO),
                        new Marca(Marca.Marcas.HONDA), new Kilometraje(1000), new TipoMoto(2020, "CB150R")
                );
        var tipoCliente = new TipoCliente(TipoCliente.TipoClientes.FRECUENTE);
        var command = new CrearCliente(personaId, nombre, motoFactory, tipoCliente);
        var usecase = new CrearClienteUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (ClienteCreado) events.get(0);
        assertEquals("10002353", event.getPersonaId().value());
        assertEquals("Steven", event.getNombre().value());
        assertEquals("ABC12S", event.getPlaca().value());
        assertEquals("4Y1SL65848Z411439", event.getVin().value());
        assertEquals(Motor.Motores.BICILINDRICO, event.getMotor().value());
        assertEquals(Marca.Marcas.HONDA, event.getMarca().value());
        assertEquals(1000, event.getKilometraje().value());
        assertEquals("CB150R2020", event.getTipoMoto().value());
        assertEquals(TipoCliente.TipoClientes.FRECUENTE, event.getTipoCliente().value());
    }
}
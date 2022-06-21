package co.com.sofka.reto.cliente.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.ClienteCreado;
import co.com.sofka.reto.cliente.commands.ActualizarKilometrajeDeLaMoto;
import co.com.sofka.reto.cliente.events.KilometrajeDeLaMotoActualizado;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.cliente.identities.PersonaId;
import co.com.sofka.reto.cliente.identities.Placa;
import co.com.sofka.reto.cliente.values.*;
import co.com.sofka.reto.generic.values.Nombre;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class ActualizarKilometrajeDeLaMotoUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    ActualizarKilometrajeDeLaMotoUseCase useCase;

    @Test
    void actualizarKilometrajeDeLaMoto() {
        //arrange
        var clienteId = ClienteId.of("CLI1234");
        var placa = Placa.from("ABC12S");
        var kilometraje = new Kilometraje(1200);
        var command = new ActualizarKilometrajeDeLaMoto(clienteId, placa, kilometraje);
        Mockito.when(repository.getEventsBy(clienteId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (KilometrajeDeLaMotoActualizado) events.get(0);
        Assertions.assertEquals("ABC12S", event.getPlaca().value());
        Assertions.assertEquals(1200, event.getKilometraje().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new ClienteCreado(PersonaId.of("10002353"), new Nombre("Steven"), Placa.from("ABC12S"), new Vin("4Y1SL65848Z411439"),
                        new Motor(Motor.Motores.BICILINDRICO), new Marca(Marca.Marcas.HONDA), new Kilometraje(1000),
                        new TipoMoto(2020, "CB150R"), new TipoCliente(TipoCliente.TipoClientes.FRECUENTE))
        );
    }
}
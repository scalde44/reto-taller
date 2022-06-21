package co.com.sofka.reto.ordentaller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.commands.CambiarEstadoOrdenDeTaller;
import co.com.sofka.reto.ordentaller.events.EstadoOrdenDeTallerCambiado;
import co.com.sofka.reto.ordentaller.events.OrdenDeTallerAbierta;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class CambiarEstadoOrdenDeTallerUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    CambiarEstadoOrdenDeTallerUseCase useCase;

    @Test
    void cambiarEstadoOrdenDeTaller() {
        //arrange
        var ordenTallerId = OrdenTallerId.of("OT001");
        var estadoOrden = new EstadoOrden(EstadoOrden.EstadosOrden.PROGRESO);
        var command = new CambiarEstadoOrdenDeTaller(ordenTallerId, estadoOrden);
        Mockito.when(repository.getEventsBy(ordenTallerId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (EstadoOrdenDeTallerCambiado) events.get(0);
        Assertions.assertEquals(EstadoOrden.EstadosOrden.PROGRESO, event.getEstadoOrden().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new OrdenDeTallerAbierta(TecnicoId.of("1312412"), new EstadoTecnico(EstadoTecnico.EstadosTecnico.DISPONIBLE),
                        new Nombre("Fabian"), new Especialidad(Especialidad.Especialidades.ELECTRICO), OperacionId.of("OPE001"),
                        new Tempario(1), new Categoria(Categoria.Categorias.REVISION), new Valor(BigDecimal.valueOf(60000)), ClienteId.of("CLI1234"))
        );
    }
}
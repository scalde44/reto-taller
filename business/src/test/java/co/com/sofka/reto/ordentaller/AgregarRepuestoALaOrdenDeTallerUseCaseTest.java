package co.com.sofka.reto.ordentaller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.commands.AgregarRepuestoALaOrdenDeTaller;
import co.com.sofka.reto.ordentaller.events.OrdenDeTallerAbierta;
import co.com.sofka.reto.ordentaller.events.RepuestoAgregadoALaOrdenDeTaller;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.usecases.AgregarRepuestoALaOrdenDeTallerUseCase;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;
import co.com.sofka.reto.ordentaller.values.Tempario;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
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
class AgregarRepuestoALaOrdenDeTallerUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    AgregarRepuestoALaOrdenDeTallerUseCase useCase;

    @Test
    void agregarRepuestoALaOrdenDeTaller() {
        //arrange
        var ordenTallerId = OrdenTallerId.of("OT001");
        var repuestoId = RepuestoId.of("REP001");
        var command = new AgregarRepuestoALaOrdenDeTaller(ordenTallerId, repuestoId);
        Mockito.when(repository.getEventsBy(ordenTallerId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RepuestoAgregadoALaOrdenDeTaller) events.get(0);
        Assertions.assertEquals("REP001", event.getRepuestoId().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new OrdenDeTallerAbierta(TecnicoId.of("1312412"), new EstadoTecnico(EstadoTecnico.EstadosTecnico.DISPONIBLE),
                        new Nombre("Fabian"), new Especialidad(Especialidad.Especialidades.ELECTRICO), OperacionId.of("OPE001"),
                        new Tempario(1), new Categoria(Categoria.Categorias.REVISION), new Valor(BigDecimal.valueOf(60000)), ClienteId.of("CLI1234"))
        );
    }
}
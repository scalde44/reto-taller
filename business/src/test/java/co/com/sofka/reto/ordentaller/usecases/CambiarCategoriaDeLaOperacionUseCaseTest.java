package co.com.sofka.reto.ordentaller.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.commands.CambiarCategoriaDeLaOperacion;
import co.com.sofka.reto.ordentaller.events.CategoriaDeLaOperacionCambiada;
import co.com.sofka.reto.ordentaller.events.OrdenDeTallerAbierta;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.OrdenTallerId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.usecases.CambiarCategoriaDeLaOperacionUseCase;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;
import co.com.sofka.reto.ordentaller.values.Tempario;
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
class CambiarCategoriaDeLaOperacionUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    CambiarCategoriaDeLaOperacionUseCase useCase;

    @Test
    void cambiarCategoriaDeLaOperacion() {
        //arrange
        var ordenTallerId = OrdenTallerId.of("OT001");
        var operacionId = OperacionId.of("OPE001");
        var categoria = new Categoria(Categoria.Categorias.SINCRONIZACION);
        var command = new CambiarCategoriaDeLaOperacion(ordenTallerId, operacionId, categoria);
        Mockito.when(repository.getEventsBy(ordenTallerId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (CategoriaDeLaOperacionCambiada) events.get(0);
        Assertions.assertEquals("OPE001", event.getOperacionId().value());
        Assertions.assertEquals(Categoria.Categorias.SINCRONIZACION, event.getCategoria().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new OrdenDeTallerAbierta(TecnicoId.of("1312412"), new EstadoTecnico(EstadoTecnico.EstadosTecnico.DISPONIBLE),
                        new Nombre("Fabian"), new Especialidad(Especialidad.Especialidades.ELECTRICO), OperacionId.of("OPE001"),
                        new Tempario(1), new Categoria(Categoria.Categorias.REVISION), new Valor(BigDecimal.valueOf(60000)), ClienteId.of("CLI1234"))
        );
    }
}
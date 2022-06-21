package co.com.sofka.reto.repuesto.usecases;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.events.RepuestoAgregadoALaOrdenDeTaller;
import co.com.sofka.reto.repuesto.events.RepuestoCreado;
import co.com.sofka.reto.repuesto.events.StockDisminuido;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.identities.RepuestoId;
import co.com.sofka.reto.repuesto.values.Antiguedad;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;
import co.com.sofka.reto.repuesto.values.Stock;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;
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
class DisminuirStockUseCaseTest {
    @Mock
    DomainEventRepository repository;
    @InjectMocks
    DisminuirStockUseCase useCase;

    @Test
    void disminuirStock() {
        //arrange
        var repuestoId = RepuestoId.of("REP001");
        var eventInput = new RepuestoAgregadoALaOrdenDeTaller(repuestoId);
        Mockito.when(repository.getEventsBy(repuestoId.value())).thenReturn(history());
        useCase.addRepository(repository);

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(eventInput))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var eventOutput = (StockDisminuido) events.get(0);
        Assertions.assertEquals(1, eventOutput.getStock().value());
    }

    private List<DomainEvent> history() {
        return List.of(
                new RepuestoCreado(ProveedorId.of("PROV102"), new Nombre("MOTOPARTES"), new ClasificacionTributaria(ClasificacionTributaria.ClasificacionesTributarias.MICRO),
                        AsesorId.of("ASE1002"), new Nombre("Juliana"), new Antiguedad(1), UbicacionId.of("UBI002"), new Stock(10), new Valor(BigDecimal.valueOf(45000)))
        );
    }
}
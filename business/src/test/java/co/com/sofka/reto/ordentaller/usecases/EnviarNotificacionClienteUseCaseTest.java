package co.com.sofka.reto.ordentaller.usecases;

import co.com.sofka.business.generic.ServiceBuilder;
import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.events.OrdenDeTallerAbierta;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.services.SenderNotification;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;
import co.com.sofka.reto.ordentaller.values.Tempario;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class EnviarNotificacionClienteUseCaseTest {
    @Mock
    SenderNotification service;

    @InjectMocks
    EnviarNotificacionClienteUseCase useCase;

    @Test
    void enviarNotificacion() {
        var event = new OrdenDeTallerAbierta(TecnicoId.of("1312412"), new EstadoTecnico(EstadoTecnico.EstadosTecnico.DISPONIBLE),
                new Nombre("Fabian"), new Especialidad(Especialidad.Especialidades.ELECTRICO), OperacionId.of("OPE001"),
                new Tempario(1), new Categoria(Categoria.Categorias.REVISION), new Valor(BigDecimal.valueOf(60000)), ClienteId.of("CLI1234"));
        doNothing().when(service).sendNotificacion(any(), any());
        useCase.addServiceBuilder(new ServiceBuilder().addService(service));

        var events = UseCaseHandler.getInstance()
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();

        verify(service).sendNotificacion(any(), any());
    }
}
package co.com.sofka.reto.ordentaller;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.cliente.identities.ClienteId;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.ordentaller.commands.AbrirOrdenDeTaller;
import co.com.sofka.reto.ordentaller.events.OrdenDeTallerAbierta;
import co.com.sofka.reto.ordentaller.identities.OperacionId;
import co.com.sofka.reto.ordentaller.identities.TecnicoId;
import co.com.sofka.reto.ordentaller.values.Categoria;
import co.com.sofka.reto.ordentaller.values.Especialidad;
import co.com.sofka.reto.ordentaller.values.EstadoTecnico;
import co.com.sofka.reto.ordentaller.values.Tempario;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class AbrirOrdenDeTallerUseCaseTest {
    @Test
    void abrirOrdenDeTaller() {
        //arrange
        var tecnicoFactory = TecnicoFactory.getInstance()
                .crear(TecnicoId.of("1312412"), new EstadoTecnico(EstadoTecnico.EstadosTecnico.DISPONIBLE),
                        new Nombre("Fabian"), new Especialidad(Especialidad.Especialidades.ELECTRICO)
                );
        var operacionFactory = OperacionFactory.getInstance()
                .crear(OperacionId.of("OPE001"), new Tempario(1), new Categoria(Categoria.Categorias.REVISION), new Valor(new BigDecimal(60000)));
        var clienteId = ClienteId.of("CLI1234");
        var command = new AbrirOrdenDeTaller(tecnicoFactory, operacionFactory, clienteId);
        var usecase = new AbrirOrdenDeTallerUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (OrdenDeTallerAbierta) events.get(0);
        Assertions.assertEquals("1312412", event.getTecnicoId().value());
        Assertions.assertEquals(EstadoTecnico.EstadosTecnico.DISPONIBLE, event.getEstadoTecnico().value());
        Assertions.assertEquals("Fabian", event.getNombre().value());
        Assertions.assertEquals(Especialidad.Especialidades.ELECTRICO, event.getEspecialidad().value());
        Assertions.assertEquals("OPE001", event.getOperacionId().value());
        Assertions.assertEquals(1, event.getTempario().value());
        Assertions.assertEquals(Categoria.Categorias.REVISION, event.getCategoria().value());
        Assertions.assertEquals(new BigDecimal(60000), event.getValor().value());
        Assertions.assertEquals("CLI1234", event.getClienteId().value());
    }
}
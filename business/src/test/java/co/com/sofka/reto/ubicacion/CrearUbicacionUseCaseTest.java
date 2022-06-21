package co.com.sofka.reto.ubicacion;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.ubicacion.commands.CrearUbicacion;
import co.com.sofka.reto.ubicacion.identities.EspacioId;
import co.com.sofka.reto.ubicacion.usecases.CrearUbicacionUseCase;
import co.com.sofka.reto.ubicacion.values.Categoria;
import co.com.sofka.reto.ubicacion.values.Direccion;
import co.com.sofka.reto.ubicacion.values.Estado;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CrearUbicacionUseCaseTest {
    @Test
    void crearUbicacion() {
        //arrange
        var espacioId = EspacioId.of("ESPA012");
        var estado = new Estado(Estado.Estados.DISPONIBLE);
        var direccion = new Direccion("P1", "E1", "C1");
        var categoria = new Categoria(Categoria.Categorias.MANTENIMIENTO);
        var command = new CrearUbicacion(espacioId, estado, direccion, categoria);
        var usecase = new CrearUbicacionUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (UbicacionCreada) events.get(0);
        Assertions.assertEquals("ESPA012", event.getEspacioId().value());
        Assertions.assertEquals(Estado.Estados.DISPONIBLE, event.getEstado().value());
        Assertions.assertEquals("P1E1C1", event.getDireccion().value());
        Assertions.assertEquals(Categoria.Categorias.MANTENIMIENTO, event.getCategoria().value());
    }
}
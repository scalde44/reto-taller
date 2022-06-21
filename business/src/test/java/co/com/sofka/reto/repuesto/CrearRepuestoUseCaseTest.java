package co.com.sofka.reto.repuesto;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.reto.generic.values.Nombre;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.repuesto.commands.CrearRepuesto;
import co.com.sofka.reto.repuesto.events.RepuestoCreado;
import co.com.sofka.reto.repuesto.identities.AsesorId;
import co.com.sofka.reto.repuesto.identities.ProveedorId;
import co.com.sofka.reto.repuesto.values.Antiguedad;
import co.com.sofka.reto.repuesto.values.ClasificacionTributaria;
import co.com.sofka.reto.repuesto.values.Stock;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

class CrearRepuestoUseCaseTest {
    @Test
    void crearRepuesto() {
        //arrange
        var proveedorFactory = ProveedorFactory.getInstance()
                .crear(
                        ProveedorId.of("PROV102"), new Nombre("MOTOPARTES"), new ClasificacionTributaria(ClasificacionTributaria.ClasificacionesTributarias.MICRO)
                );
        var asesorFactory = AsesorFactory.getInstance()
                .crear(
                        AsesorId.of("ASE1002"), new Nombre("Juliana"), new Antiguedad(1)
                );
        var ubicacionId = UbicacionId.of("UBI002");
        var stock = new Stock(10);
        var valor = new Valor(BigDecimal.valueOf(45000));
        var command = new CrearRepuesto(proveedorFactory, asesorFactory, ubicacionId, stock, valor);
        var usecase = new CrearRepuestoUseCase();

        //act
        var events = UseCaseHandler.getInstance()
                .syncExecutor(usecase, new RequestCommand<>(command))
                .orElseThrow()
                .getDomainEvents();

        //assert
        var event = (RepuestoCreado) events.get(0);
        Assertions.assertEquals("PROV102", event.getProveedorId().value());
        Assertions.assertEquals("MOTOPARTES", event.getNombreProveedor().value());
        Assertions.assertEquals(ClasificacionTributaria.ClasificacionesTributarias.MICRO, event.getClasificacionTributaria().value());
        Assertions.assertEquals("ASE1002", event.getAsesorId().value());
        Assertions.assertEquals("Juliana", event.getNombreAsesor().value());
        Assertions.assertEquals(1, event.getAntiguedad().value());
        Assertions.assertEquals("UBI002", event.getUbicacionId().value());
        Assertions.assertEquals(10, event.getStock().value());
        Assertions.assertEquals(BigDecimal.valueOf(45000), event.getValor().value());
    }
}
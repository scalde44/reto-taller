package co.com.sofka.reto.repuesto.commands;

import co.com.sofka.domain.generic.Command;
import co.com.sofka.reto.generic.values.Valor;
import co.com.sofka.reto.repuesto.AsesorFactory;
import co.com.sofka.reto.repuesto.ProveedorFactory;
import co.com.sofka.reto.repuesto.values.Stock;
import co.com.sofka.reto.ubicacion.identities.UbicacionId;

public class CrearRepuesto extends Command {
    private final ProveedorFactory proveedorFactory;
    private final AsesorFactory asesorFactory;
    private final UbicacionId ubicacionId;
    private final Stock stock;
    private final Valor valor;

    public CrearRepuesto(ProveedorFactory proveedorFactory, AsesorFactory asesorFactory, UbicacionId ubicacionId, Stock stock, Valor valor) {
        this.proveedorFactory = proveedorFactory;
        this.asesorFactory = asesorFactory;
        this.ubicacionId = ubicacionId;
        this.stock = stock;
        this.valor = valor;
    }

    public ProveedorFactory getProveedorFactory() {
        return proveedorFactory;
    }

    public AsesorFactory getAsesorFactory() {
        return asesorFactory;
    }

    public UbicacionId getUbicacionId() {
        return ubicacionId;
    }

    public Stock getStock() {
        return stock;
    }

    public Valor getValor() {
        return valor;
    }
}

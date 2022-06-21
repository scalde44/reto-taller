package co.com.sofka.reto.cliente.identities;

import co.com.sofka.domain.generic.Identity;

import java.util.Objects;

public class Placa extends Identity {
    private Placa(String placa) {
        super(placa);
    }

    public static Placa from(String placa) {
        Objects.requireNonNull(placa);
        if (!placa.matches("^[a-zA-Z]{3}[0-9]{3}|[a-zA-Z]{3}[0-9]{2}[a-zA-Z]$")) {
            throw new IllegalArgumentException("Ingresa una placa valida");
        }
        return new Placa(placa);
    }
}

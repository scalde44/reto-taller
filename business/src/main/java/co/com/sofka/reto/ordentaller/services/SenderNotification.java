package co.com.sofka.reto.ordentaller.services;

import co.com.sofka.reto.cliente.identities.ClienteId;

public interface SenderNotification {
    void sendNotificacion(ClienteId clienteId, String message);
}

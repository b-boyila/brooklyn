package service;

import model.Client;

import java.util.Collection;

/**
 * Created by ktagintsev on 21.09.15.
 */
public interface ClientService {

    void add(Client client);

    Collection<Client> getClients();

    void delete(Client client);

    void update(Client client);
}

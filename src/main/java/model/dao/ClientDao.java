package model.dao;

import model.Client;

import java.util.Collection;

/**
 * Created by ktagintsev on 21.09.15.
 */
public interface ClientDao {

    void add(Client client);

    Collection<Client> getClients();

    void delete(Client client);

    void update(Client client);
}

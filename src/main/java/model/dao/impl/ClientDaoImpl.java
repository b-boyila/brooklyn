package model.dao.impl;

import model.Client;
import model.dao.ClientDao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

/**
 * Created by ktagintsev on 21.09.15.
 */
public class ClientDaoImpl implements ClientDao {

    @PersistenceContext
    private EntityManager emf;

    @Override
    public void add(Client client) {
        emf.persist(client);
    }

    @Override
    public Collection<Client> getClients() {
            return emf.createQuery(
                    "select c from Client c")
                    .getResultList();

    }

    @Override
    public void delete(Client client) {
        emf.remove(emf.getReference(Client.class, client.getId()));
    }

    @Override
    public void update(Client client) {
        emf.merge(client);
    }
}

package model.dao.impl;

import help.Search;
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
    public Collection<Client> getClients(Search search) {
        if (search.isEmpty()) {
            return emf.createQuery(
                    "select c from Client c")
                    .getResultList();
        }
        return searchClients(search);

    }

    @Override
    public void delete(Client client) {
        emf.remove(emf.getReference(Client.class, client.getId()));
    }

    @Override
    public void update(Client client) {
        emf.merge(client);
    }

    private Collection<Client> searchClients(Search search){
System.out.println(search.toString());
       return emf.createQuery(
                "select c from Client c where c.firstName like :name and c.email like :email and c.phone like :phone")
                .setParameter("name", "%" + search.getName() + "%")
                .setParameter("email", "%" + search.getEmail() + "%")
                .setParameter("phone", "%" + search.getPhone() + "%")
                .getResultList();
    }
}

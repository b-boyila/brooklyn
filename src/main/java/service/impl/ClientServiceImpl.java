package service.impl;

import model.Client;
import model.dao.ClientDao;
import org.springframework.transaction.annotation.Transactional;
import service.ClientService;

import java.util.Collection;

/**
 * Created by ktagintsev on 21.09.15.
 */
public class ClientServiceImpl implements ClientService {

    private ClientDao clientDao;

    @Transactional
    @Override
    public void add(Client client) {
        clientDao.add(client);
    }

    @Transactional
    @Override
    public Collection<Client> getClients() {
        return clientDao.getClients();
    }

    @Transactional
    @Override
    public void delete(Client client) {
        clientDao.delete(client);
    }

    public ClientDao getClientDao() {
        return clientDao;
    }

    public void setClientDao(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @Transactional
    @Override
    public void update(Client client) {
        clientDao.update(client);
    }
}

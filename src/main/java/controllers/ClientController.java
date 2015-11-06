package controllers;

import model.Client;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ClientService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by ktagintsev on 21.09.15.
 */
@Controller
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "create", method = RequestMethod.POST)
    @ResponseBody
    public Boolean create(@RequestBody Client client) {
        client.setDateRequest(new SimpleDateFormat("dd/MM/yy").format(new Date()));
        clientService.add(client);
        return true;
    }

    @RequestMapping(value = "read", method = RequestMethod.GET)
    @ResponseBody
    public Collection<Client> read() {
        List<Client> clients = new ArrayList<Client>();
        insertData(clients);
        return clients;
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    @ResponseBody
    public Boolean update(@RequestBody Client client) {
        clientService.update(client);
        return true;
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST)
    @ResponseBody
    public Boolean delete(@RequestBody Client client) {
        clientService.delete(client);
        return true;
    }

    private void insertData(List<Client> list){
        Collection<Client> clients = clientService.getClients();
        for(Client c: clients){
            Client client = new Client();
            client.setId(c.getId());
            client.setFirstName(c.getFirstName());
            client.setSecondName(c.getSecondName());
            client.setLastName(c.getLastName());
            client.setHappyBirthday(c.getHappyBirthday());
            client.setPhone(c.getPhone());
            client.setEmail(c.getEmail());
            client.setStatus(c.getStatus());
            client.setParents(c.getParents());
            client.setStory(c.getStory());
            client.setDateRequest(c.getDateRequest());
            list.add(client);
        }

    }
}

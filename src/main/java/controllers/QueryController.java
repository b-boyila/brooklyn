package controllers;

import model.Client;
import model.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import service.ClientService;

/**
 * Created by ktagintsev on 13.10.15.
 */
@Controller
@RequestMapping("/mail")
public class QueryController {

    @Autowired
    private ClientService clientService;

    @RequestMapping(value = "query", method = RequestMethod.POST)
    @ResponseBody
    public Boolean create(@RequestBody Query query) {
        Client client = new Client();
        client.setFirstName(query.getName());
        client.setPhone(query.getPhone());
        client.setEmail(query.getMail());
        clientService.add(client);
        return true;
    }

}

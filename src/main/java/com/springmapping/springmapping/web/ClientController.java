package com.springmapping.springmapping.web;

import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ClientController {

     ClientServiceImpl clientService;

    public  ClientController(ClientServiceImpl clientService){
        this.clientService=clientService;
    }

    @GetMapping("/api/clients")
    public List<Client>getClients(){
        return  this.clientService.getClients();
    }


}

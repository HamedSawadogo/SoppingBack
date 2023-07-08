package com.springmapping.springmapping.service;

import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImpl implements  ClientService{

    private  ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }

    @Override
    public List<Client> getClients() {
        return this.clientRepository.findAll();
    }
}

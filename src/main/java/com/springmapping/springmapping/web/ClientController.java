package com.springmapping.springmapping.web;

import com.springmapping.springmapping.Exceptions.ProductNotFoundExecption;
import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.entities.Dto.ClientDto;
import com.springmapping.springmapping.service.ClientServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class ClientController {

     ClientServiceImpl clientService;

    public  ClientController(ClientServiceImpl clientService){
        this.clientService=clientService;
    }

    @GetMapping("/api/clients")
    public ResponseEntity<List<ClientDto>> getClients(){
        try{
            return ResponseEntity.ok().body(this.clientService.getEntities());
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }
    }
    @GetMapping("/api/client/{id}")
    public  ResponseEntity<ClientDto> getClient(@PathVariable("id")String clientId){
        try {
            return  ResponseEntity.ok().body(this.clientService.findEntityByid(clientId));
        } catch (Exception e) {
           return  ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/api/add/client")
    public  ResponseEntity<ClientDto>addClient(@RequestBody ClientDto clientDto){
        try {
            return  ResponseEntity.ok().body(this.clientService.saveEntity(clientDto));
        } catch (ProductNotFoundExecption e) {
           return  ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/api/client/delete/{id}")
    public  ResponseEntity<String>deleteClient(@PathVariable("id")String clientId){
        try {
            this.clientService.deleteEntityById(clientId);
            return  ResponseEntity.ok().body("Client supprimé avec success");
        } catch (Exception e) {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/api/client/nom/{name}")
    public ResponseEntity<ClientDto>findClientByName(@PathVariable("name")String clientName){
        try{
            return  ResponseEntity.ok().body(this.clientService.findByName(clientName)) ;
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }

    }



}

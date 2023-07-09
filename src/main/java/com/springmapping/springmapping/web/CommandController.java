package com.springmapping.springmapping.web;

import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.entities.Dto.CommandDto;
import com.springmapping.springmapping.service.CommandServiveImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CommandController {

    CommandServiveImpl commandServive;
    public  CommandController(CommandServiveImpl commandServive){
        this.commandServive=commandServive;
    }

    @GetMapping("/api/commandes")
    public ResponseEntity<List<CommandDto>>getClients(){
        try{
            return  ResponseEntity.ok().body(this.commandServive.getEntities());
        }catch (Exception e){
            return  ResponseEntity.notFound().build();
        }

    }

}

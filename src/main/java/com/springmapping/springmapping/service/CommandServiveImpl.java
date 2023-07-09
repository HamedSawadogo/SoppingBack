package com.springmapping.springmapping.service;

import com.springmapping.springmapping.Exceptions.ClientNotFoundException;
import com.springmapping.springmapping.Exceptions.CommandeNotFoundExecption;
import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.entities.Commande;
import com.springmapping.springmapping.entities.Dto.CommandDto;
import com.springmapping.springmapping.entities.Dto.CommandLineDto;
import com.springmapping.springmapping.repository.ClientRepository;
import com.springmapping.springmapping.repository.CommandRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CommandServiveImpl implements CommandeService<CommandDto,Long>, IDto<Commande,CommandDto>{

    CommandRepository commandRepository;
    ClientRepository clientRepository;
    ModelMapper modelMapper;

    public  CommandServiveImpl(CommandRepository commandRepository, ModelMapper modelMapper, ClientRepository clientRepository){

        this.commandRepository=commandRepository;
        this.modelMapper=modelMapper;
        this.clientRepository=clientRepository;
    }
    /**
     * rechercher une commande par son Id
     * @param commandId
     * @return
     * @throws CommandeNotFoundExecption
     */
    @Override
    public CommandDto findEntityByid(Long commandId) throws CommandeNotFoundExecption {
        return this.convertEntityToDto(this.commandRepository.findById(commandId)
                .orElseThrow(()->new CommandeNotFoundExecption("cette commande n'existe pas")));
    }

    /**
     * obtenir la liste des commandes
     * @return
     */
    @Override
    public List<CommandDto> getEntities() {
        return this.commandRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * supprimer une Commande
     * @param aLong
     * @throws Exception
     */

    @Override
    public void deleteEntityById(Long commandId) throws CommandeNotFoundExecption {
        Optional<Commande>commande=this.commandRepository.findById(commandId);
        if(commande.isPresent()){
            this.commandRepository.deleteById(commandId);
            return;
        }
        throw new CommandeNotFoundExecption("cette commande n'existe pas");
    }
    /**
     * Ajouter une nouvelle commande a un CLient
     * @param clientId
     * @param commandeDto
     * @return
     * @throws Exception
     */
    @Override
    public CommandDto saveEntity(String clientId, CommandDto commandeDto) throws Exception {

        if(Objects.isNull(commandeDto)){
            throw new CommandeNotFoundExecption("une erreur est survenue");
        }
        //Rechercher le client par son Id
        Client client=this.clientRepository.findById(clientId).orElseThrow(()->
                new ClientNotFoundException("ce client n'existe pas"));
        //associer Une commande et le  persister
        Commande commande=this.convertDtoToEntity(commandeDto);
        client.addCommande(commande);

        this.clientRepository.save(client);

        return this.convertEntityToDto(this.commandRepository.save(commande));

    }

    @Override
    public void updateEntity(Long aLong, CommandDto entity) throws Exception {

    }
    @Override
    public CommandDto convertEntityToDto(Commande commande) {
        return modelMapper.map(commande,CommandDto.class);
    }

    @Override
    public Commande convertDtoToEntity(CommandDto dto) {
        return modelMapper.map(dto,Commande.class);
    }
}

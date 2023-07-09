package com.springmapping.springmapping.service;

import com.springmapping.springmapping.Exceptions.ClientNotFoundException;
import com.springmapping.springmapping.Exceptions.ProductNotFoundExecption;
import com.springmapping.springmapping.entities.Client;
import com.springmapping.springmapping.entities.Dto.ClientDto;
import com.springmapping.springmapping.entities.Dto.ProductDto;
import com.springmapping.springmapping.entities.Product;
import com.springmapping.springmapping.repository.ClientRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements  ClientService ,IDto<Client, ClientDto>{

    ClientRepository clientRepository;
    ModelMapper modelMapper;


    public ClientServiceImpl(ClientRepository clientRepository, ModelMapper modelMapper){
        this.clientRepository=clientRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public ClientDto convertEntityToDto(Client client) {
        return modelMapper.map(client,ClientDto.class);
    }

    @Override
    public Client convertDtoToEntity(ClientDto dto) {
        return modelMapper.map(dto,Client.class);
    }
    /**
     * rechercher un client par son Id
     * @param clientId
     * @return
     * @throws Exception
     */
    @Override
    public ClientDto findEntityByid(String clientId) throws Exception {
        return  this.convertEntityToDto(this.clientRepository.findById(clientId)
                .orElseThrow(()-> new ClientNotFoundException("ce client n'existe pas"))) ;
    }
    /**
     * renvoie la liste des clients DTO
     * @return
     */

    @Override
    public List<ClientDto> getEntities() {
        return this.clientRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * supprimer un CLient DTO par son Id
     * @param clientId
     * @throws Exception
     */
    @Override
    public void deleteEntityById(String clientId) throws Exception {
         Optional<Client>clientOptional=this.clientRepository.findById(clientId);
         if(clientOptional.isPresent()){
             this.clientRepository.deleteById(clientId);
             return;
         }
         throw new ClientNotFoundException("ce client n'existe pas");
    }
    /**
     * enregistrer Un client
     * @param clientDto
     * @return
     * @throws ProductNotFoundExecption
     */
    @Override
    public ClientDto saveEntity(ClientDto clientDto) throws ProductNotFoundExecption {
        Client client=this.convertDtoToEntity(clientDto);
        client.setId(UUID.randomUUID().toString());
        return this.convertEntityToDto(this.clientRepository.save(client));
    }

    /**
     * rechercher la liste des clients par Nom
     * @param clientName
     * @return
     */
    @Override
    public List<ClientDto> findAllByName(String clientName) {
        return this.clientRepository.findAllByNom(clientName)
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    /**
     * modification de CLient
     * @param clientID
     * @param dto
     * @throws ClientNotFoundException
     */
    @Override
    public void updateEntity(String clientID, ClientDto dto) throws ClientNotFoundException {
        Optional<Client> clientOptional=this.clientRepository.findById(clientID);
        if(clientOptional.isPresent()){
            ClientDto clientDto=this.convertEntityToDto(clientOptional.get());
            clientDto.setNom(dto.getNom());
            clientDto.setEmail(dto.getEmail());
            clientDto.setTelephone(dto.getTelephone());

        }else{
            throw new ClientNotFoundException("ce Client n'existe pas");
        }
    }
    /**
     * recher un CLient Par son Nom
     * @param clientName
     * @return
     */
    @Override
    public ClientDto findByName(String clientName) {
        return this.convertEntityToDto(this.clientRepository.findByNom(clientName));
    }

}

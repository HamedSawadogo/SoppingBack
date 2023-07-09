package com.springmapping.springmapping.service;

import java.util.List;

public interface CommandeService<T,ID>{
    T findEntityByid(ID id) throws Exception;
    List<T> getEntities();
    void deleteEntityById(ID id) throws Exception;
    T saveEntity(String clientId,T commande) throws Exception;
    void updateEntity(ID id,T commande) throws Exception;
}


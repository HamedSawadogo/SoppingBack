package com.springmapping.springmapping.service;
import com.springmapping.springmapping.Exceptions.ProductNotFoundExecption;

import java.util.List;
public interface IMetier<T,ID>{

    T findEntityByid(ID id) throws Exception;
    List<T>getEntities();
    void deleteEntityById(ID id) throws Exception;
    T saveEntity(T entity) throws ProductNotFoundExecption;
    List<T>findAllByName(String name);
    void updateEntity(ID id,T entity) throws ProductNotFoundExecption;
    T findByName(String name);

}

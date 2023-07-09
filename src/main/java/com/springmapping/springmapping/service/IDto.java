package com.springmapping.springmapping.service;

public interface IDto<E,D>{
    D convertEntityToDto(E entity);
    E convertDtoToEntity(D dto);
}

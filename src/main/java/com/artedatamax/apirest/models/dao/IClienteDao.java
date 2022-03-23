package com.artedatamax.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.artedatamax.apirest.models.entity.Cliente;

public interface IClienteDao extends CrudRepository<Cliente, Long>{

}

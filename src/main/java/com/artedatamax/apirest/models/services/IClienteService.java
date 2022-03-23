package com.artedatamax.apirest.models.services;

import java.util.List;

import com.artedatamax.apirest.models.entity.Cliente;

public interface IClienteService {
	
	public List<Cliente> findAll();

}

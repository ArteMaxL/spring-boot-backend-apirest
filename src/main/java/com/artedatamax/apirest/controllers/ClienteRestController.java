package com.artedatamax.apirest.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com.artedatamax.apirest.models.entity.Cliente;
import com.artedatamax.apirest.models.services.IClienteService;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api")
public class ClienteRestController {
	
	@Autowired
	private IClienteService clienteService;
	
	@GetMapping("/clientes")
	public List<Cliente> index(){
		return clienteService.findAll();
	}

	@GetMapping("/clientes/{id}")
	//@ResponseStatus(HttpStatus.OK)
	public Cliente show(@PathVariable Long id){
		return clienteService.findById(id);
	}

	@PostMapping("/clientes")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente create(@RequestBody Cliente cliente){
		//cliente.setCreatedAt(new Date());
		return clienteService.save(cliente);
	}

	@PutMapping("/clientes/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente update(@RequestBody Cliente cliente,
						  @PathVariable Long id){
		Cliente clienteActual = clienteService.findById(id);

		clienteActual.setNombre(cliente.getNombre());
		clienteActual.setApellido(cliente.getApellido());
		clienteActual.setEmail(cliente.getEmail());

		return clienteService.save(clienteActual);
	}

	@DeleteMapping("clientes/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Long id){
		clienteService.delete(id);
	}
}

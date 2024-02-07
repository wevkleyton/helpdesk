package com.suporte.helpdesk.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suporte.helpdesk.domain.Pessoa;
import com.suporte.helpdesk.domain.Tecnico;
import com.suporte.helpdesk.domain.dtos.TecnicoDTO;
import com.suporte.helpdesk.repositores.PessoaRepository;
import com.suporte.helpdesk.repositores.TecnicoRepository;
import com.suporte.helpdesk.services.exceptions.DataIntegrityViolationException;
import com.suporte.helpdesk.services.exceptions.ObjectnotFoundException;

@Service
public class TecnicoService {

	@Autowired
	private TecnicoRepository repository;
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public Tecnico findById(Integer id) {
		Optional<Tecnico> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectnotFoundException("Object nao encontrado! id: " + id));
	}

	public List<Tecnico> findAll() {
		return repository.findAll();
	}

	public Tecnico create(TecnicoDTO objTDO) {
		objTDO.setId(null);
		validaPorCpfEEmail(objTDO);
		Tecnico newObj = new Tecnico(objTDO);
		return repository.save(newObj);
	}

	private void validaPorCpfEEmail(TecnicoDTO objDTO) {
		Optional<Pessoa> obj = pessoaRepository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF ja Cadastrado no sistema!");
		}
		
		obj = pessoaRepository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("E-mail ja cadastrado no sistema!");
		}
		
	}
}


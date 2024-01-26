package com.suporte.helpdesk.repositores;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suporte.helpdesk.domain.Pessoa;
import java.util.List;


public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

	Optional<Pessoa> findByCpf(String cpf);
	Optional<Pessoa> findByEmail(String email);
}

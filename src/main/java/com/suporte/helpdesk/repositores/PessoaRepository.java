package com.suporte.helpdesk.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suporte.helpdesk.domain.Pessoa;

public interface PessoaRepository  extends JpaRepository<Pessoa, Integer>{

}

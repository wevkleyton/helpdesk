package com.suporte.helpdesk.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suporte.helpdesk.domain.Tecnico;

public interface TecnicoRepository  extends JpaRepository<Tecnico, Integer>{

}

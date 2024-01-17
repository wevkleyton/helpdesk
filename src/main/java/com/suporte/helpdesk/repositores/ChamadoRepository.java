package com.suporte.helpdesk.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suporte.helpdesk.domain.Chamado;

public interface ChamadoRepository  extends JpaRepository<Chamado, Integer>{

}

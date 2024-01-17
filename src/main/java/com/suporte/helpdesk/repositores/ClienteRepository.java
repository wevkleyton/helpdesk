package com.suporte.helpdesk.repositores;

import org.springframework.data.jpa.repository.JpaRepository;

import com.suporte.helpdesk.domain.Cliente;

public interface ClienteRepository  extends JpaRepository<Cliente, Integer>{

}

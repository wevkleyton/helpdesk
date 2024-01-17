package com.suporte.helpdesk;

import java.sql.Array;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.suporte.helpdesk.domain.Chamado;
import com.suporte.helpdesk.domain.Cliente;
import com.suporte.helpdesk.domain.Tecnico;
import com.suporte.helpdesk.domain.enums.Perfil;
import com.suporte.helpdesk.domain.enums.Prioridade;
import com.suporte.helpdesk.domain.enums.Status;
import com.suporte.helpdesk.repositores.ChamadoRepository;
import com.suporte.helpdesk.repositores.ClienteRepository;
import com.suporte.helpdesk.repositores.TecnicoRepository;

@SpringBootApplication
public class HelpdeskApplication implements CommandLineRunner {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public static void main(String[] args) {
		SpringApplication.run(HelpdeskApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		Tecnico tec1 = new Tecnico(null, "Valdir Ceza", "46397982025", "valdor@mailcom", "123");
		tec1.addPerfil(Perfil.ADMIN);

		Cliente cli1 = new Cliente(null, "Linux Torvalds", "58673897076", "torvalds@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1,
				cli1);

		tecnicoRepository.saveAll(Arrays.asList(tec1));
		clienteRepository.saveAll(Arrays.asList(cli1));
		chamadoRepository.saveAll(Arrays.asList(c1));
	}

}

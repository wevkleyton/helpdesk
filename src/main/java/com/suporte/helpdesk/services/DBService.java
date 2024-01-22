package com.suporte.helpdesk.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.suporte.helpdesk.domain.Chamado;
import com.suporte.helpdesk.domain.Cliente;
import com.suporte.helpdesk.domain.Tecnico;
import com.suporte.helpdesk.domain.enums.Perfil;
import com.suporte.helpdesk.domain.enums.Prioridade;
import com.suporte.helpdesk.domain.enums.Status;
import com.suporte.helpdesk.repositores.ChamadoRepository;
import com.suporte.helpdesk.repositores.ClienteRepository;
import com.suporte.helpdesk.repositores.TecnicoRepository;

@Service
public class DBService {

	@Autowired
	private TecnicoRepository tecnicoRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private ChamadoRepository chamadoRepository;

	public void instanciaDB() {
		Tecnico tec1 = new Tecnico(null, "Valdir Ceza", "46397982025", "valdor@mailcom", "123");
		tec1.addPerfil(Perfil.ADMIN);
		Tecnico tec2 = new Tecnico(null, "Richard Stallman", "90334707056", "stallman@mailcom", "123");
		Tecnico tec3 = new Tecnico(null, "Claude Elwood Shannon", "27106847054", "shannon@mailcom", "123");
		Tecnico tec4 = new Tecnico(null, "Tim Berners-Lee", "16272012039", "lee@mailcom", "123");
		Tecnico tec5 = new Tecnico(null, "Linus Torvalds", "77855617027", "linux@mailcom", "123");


		Cliente cli1 = new Cliente(null, "Albert Einstein", "11166189074", "einstein@mail.com", "123");
		Cliente cli2 = new Cliente(null, "Marie Curie", "32242914006", "curie@mail.com", "123");
		Cliente cli3 = new Cliente(null, "Charles Darwin", "79204383062", "Darwin@mail.com", "123");
		Cliente cli4 = new Cliente(null, "Stephen Hanking", "17740968030", "hanking@mail.com", "123");
		Cliente cli5 = new Cliente(null, "Max Planck", "08139930083", "planck@mail.com", "123");

		Chamado c1 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Primeiro Chamado", tec1, cli1);
		Chamado c2 = new Chamado(null, Prioridade.ALTA, Status.ABERTO, "Chamado 02", "Teste Chamado2", tec2, cli2);
		Chamado c3 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 03", "Teste Chamado3", tec3, cli3);
		Chamado c4 = new Chamado(null, Prioridade.MEDIA, Status.ANDAMENTO, "Chamado 01", "Teste Chamado4", tec4, cli4);
		Chamado c5 = new Chamado(null, Prioridade.BAIXA, Status.ENCERRADO, "Chamado 01", "Teste Chamado5", tec5, cli5);

		
		
		tecnicoRepository.saveAll(Arrays.asList(tec1,tec2,tec3,tec4,tec5));
		clienteRepository.saveAll(Arrays.asList(cli1,cli2,cli3,cli4,cli5));
		chamadoRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5));
	}
}

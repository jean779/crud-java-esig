package dao;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import domain.Colaborador;
import domain.Tarefas;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TarefasDAOTest {
	
	private TarefasDAO tarefasDAO;
	private List<Tarefas> tarefas;
	private Tarefas tarefa;
	private Colaborador vitor;
	
	@Before
	public void start() {
		tarefasDAO = new TarefasDAO();
		vitor = getColaborador();

	}
	
	private Colaborador getColaborador() {
		
		ColaboradorDAO cdao = new ColaboradorDAO();
		Colaborador colaborador = cdao.findByID(1);
		
		if(colaborador == null) {
			colaborador = new Colaborador();
			colaborador.setCargo("Desenvolvedor");
			colaborador.setNome("Vitor");
			cdao.save(colaborador);
		}
		
		return colaborador;	
	}

	@Test
	public void test1() {

		Random gerador = new Random();
		TarefasDAO tarefasdao = new TarefasDAO();
		
		
		Colaborador colaborador = getColaborador();
		colaborador.setNome("Nome "+ gerador.nextDouble());
		
		tarefa = new Tarefas();
		tarefa.setData(LocalDate.now().plusDays(1));
		tarefa.setDescricao("Programar em Java");
		tarefa.setPrioridade("Alta");
		tarefa.setTitulo("Programar "+gerador.nextDouble());
		tarefa.setResponsavel(colaborador);
		
		tarefasdao.save(tarefa);
	}

	@Test
	public void test2() {
		tarefa = tarefasDAO.findByID(1);
		Assert.assertNotNull(tarefa);
	}

	@Test
	public void test3() {
		tarefas = tarefasDAO.listar();
		
		Assert.assertNotNull(tarefas);
		Assert.assertFalse(tarefas.isEmpty());
	}

}

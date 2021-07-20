package dao;

import java.time.LocalDate;

import org.junit.Test;

import dao.ColaboradorDAO;
import dao.TarefasDAO;
import domain.Colaborador;
import domain.Tarefas;

public class ColaboradorDaoTest {
	
	@Test
	public void deveSalvarColaborador() {
		Colaborador vitor = new Colaborador();
		vitor.setNome("Jean Vitor");
		vitor.setCargo("Desenvolvedor");
		
		ColaboradorDAO dao = new ColaboradorDAO();
		dao.save(vitor);
		
	}

}

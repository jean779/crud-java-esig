package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.omnifaces.util.Messages.Message;

import domain.Colaborador;
import domain.Tarefas;
import util.JpaUtil;

public class TarefasDAO {
	public void save(Tarefas tarefa) {
		EntityManager sessao = JpaUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(tarefa);
		transacao.commit();
		sessao.close();
	}

	public Tarefas findByID(Integer id) {
		EntityManager sessao = JpaUtil.getEntityManager();
		Tarefas tarefa = sessao.find(Tarefas.class, id);
		return tarefa;
	}

	@SuppressWarnings("unchecked")
	public List<Tarefas> listar() {
		String jpql = "select t from Tarefas t order by id";

		EntityManager sessao = JpaUtil.getEntityManager();
		Query query = sessao.createQuery(jpql);
		List<Tarefas> result = query.getResultList();
		return result;
	}

	public void delete(Integer id) {
		EntityManager sessao = JpaUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		Tarefas t = sessao.find(Tarefas.class, id);
		sessao.remove(t);
		transacao.commit();
		sessao.close();
	}

	public void editar(Tarefas tarefa) {
		EntityManager sessao = JpaUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(tarefa);
		transacao.commit();
		sessao.close();

	}

	public List<Tarefas> listarTarefasNumero(Integer id) {
		String jpql = "select t from Tarefas t where t.id=" + id + " order by id";
		EntityManager sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefas> tarefas = consulta.getResultList();
		return tarefas;
	}

	public List<Tarefas> listarTarefasStatus(boolean status) {
		String jpql = "select t from Tarefas t where t.status=" + status + " order by id";
		EntityManager sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefas> tarefas = consulta.getResultList();
		return tarefas;
	}

	public List<Tarefas> listarTarefasTitulo(String titulo) {
		String jpql = "select t from Tarefas t where t.titulo like '%" + titulo + "%' order by id";
		EntityManager sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefas> tarefas = consulta.getResultList();
		return tarefas;
	}

	public List<Tarefas> listarTarefasPrioridade(String prioridade) {
		String jpql = "select t from Tarefas t where t.prioridade like '%" + prioridade + "%' order by id";
		EntityManager sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefas> tarefas = consulta.getResultList();
		return tarefas;
	}

	public List<Tarefas> listarTarefasColaborador(Colaborador colaborador) {
		String jpql = "select t from Tarefas t where t.responsavel=" + colaborador.getId() + " order by id";
		EntityManager sessao = JpaUtil.getEntityManager();
		Query consulta = sessao.createQuery(jpql);
		@SuppressWarnings("unchecked")
		List<Tarefas> tarefas = consulta.getResultList();
		return tarefas;
	}

	/*
	 * @SuppressWarnings("unchecked") public List<Tarefas>
	 * listarPorResponsavel(String nomeColaborador){ String jpql =
	 * "SELECT t FROM  Tarefas t WHERE t.responsavel.nome = '"+nomeColaborador +
	 * "' ";
	 * 
	 * EntityManager sessao = JpaUtil.getEntityManager(); Query query =
	 * sessao.createQuery(jpql); List<Tarefas> result = query.getResultList();
	 * return result; }
	 */

}

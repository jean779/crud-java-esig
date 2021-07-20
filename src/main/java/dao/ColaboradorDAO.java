package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import domain.Colaborador;
import domain.Tarefas;
import util.JpaUtil;

public class ColaboradorDAO {

	public void save(Colaborador colaborador) {
		EntityManager sessao = JpaUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.persist(colaborador);
		transacao.commit();
		sessao.close();
	}

	public Colaborador findByID(Integer id) {
		EntityManager sessao = JpaUtil.getEntityManager();
		Colaborador colaborador = sessao.find(Colaborador.class, id);
		return colaborador;
	}

	public void editar(Colaborador colaborador) {
		EntityManager sessao = JpaUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		sessao.merge(colaborador);
		transacao.commit();
		sessao.close();

	}

	public void delete(Integer id) {
		EntityManager sessao = JpaUtil.getEntityManager();
		EntityTransaction transacao = sessao.getTransaction();
		transacao.begin();
		Colaborador c = sessao.find(Colaborador.class, id);
		sessao.remove(c);
		transacao.commit();
		sessao.close();
	}

	@SuppressWarnings("unchecked")
	public List<Colaborador> listar() {
		String jpql = "select c from Colaborador c order by id";

		EntityManager sessao = JpaUtil.getEntityManager();
		Query query = sessao.createQuery(jpql);
		List<Colaborador> result = query.getResultList();
		return result;
	}

}

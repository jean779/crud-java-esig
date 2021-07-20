package main;

import javax.persistence.EntityManager;

import util.JpaUtil;

public class TestaConexao {
	public static void main(String[] args) {
		EntityManager sessao = JpaUtil.getEntityManager();
		sessao.close();
	}
}

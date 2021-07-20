package util;

import javax.persistence.EntityManager;

import org.junit.Test;

public class JpaUtilTest {
	@Test
	public void getEntityManager(){
		EntityManager sessao = JpaUtil.getEntityManager();	
	}
}

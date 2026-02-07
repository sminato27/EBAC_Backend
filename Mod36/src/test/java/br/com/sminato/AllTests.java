package br.com.sminato;

import br.com.sminato.dao.generic.GenericDAO;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({ ClienteServiceTest.class, ClienteDAOTest.class,
	ProdutoServiceTest.class, ProdutoDAOTest.class,
	VendaDAOTest.class})
public class AllTests {

	@AfterClass
	public static void tearDown() {
		GenericDAO.closeFactory();
	}
}

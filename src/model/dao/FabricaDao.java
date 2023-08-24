package model.dao;

import model.dao.impl.VendedorDaoJdbc;

public class FabricaDao {
	public static VendedorDao crearVendedorDao() {
		return new VendedorDaoJdbc();
	}
}

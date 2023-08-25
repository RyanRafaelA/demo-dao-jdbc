package model.dao;

import db.DB;
import model.dao.impl.DepartamentoDaoJdbc;
import model.dao.impl.VendedorDaoJdbc;

public class FabricaDao {
	public static VendedorDao crearVendedorDao() {
		return new VendedorDaoJdbc(DB.getConnection());
	}
	
	public static DepartamentoDao crearDepartamentoDao() {
		return new DepartamentoDaoJdbc(DB.getConnection());
	}
}

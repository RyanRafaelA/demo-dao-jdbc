package aplication;

import model.dao.FabricaDao;
import model.dao.VendedorDao;

public class Program {
	public static void main(String[] args) {
		VendedorDao vd = FabricaDao.crearVendedorDao();
		
		System.out.println("=== Teste 1: Vendedor encontraId ====");
		Vendedor vendedor = vd.encontraId(3);
		
		System.out.println(vendedor);
	}
}

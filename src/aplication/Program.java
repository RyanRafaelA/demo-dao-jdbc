package aplication;

import java.util.Date;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entities.Departamento;

public class Program {
	public static void main(String[] args) {
		Departamento obj = new Departamento(1, "books");
		
		Vendedor vendedor = new Vendedor(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);
		
		VendedorDao vd = FabricaDao.crearVendedorDao();
		
		System.out.println(vendedor);
	}
}

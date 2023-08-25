package aplication;

import java.util.List;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entities.Departamento;

public class Program {
	public static void main(String[] args) {
		VendedorDao vd = FabricaDao.crearVendedorDao();
		
		System.out.println("=== Teste 1: Vendedor encontraId ====");
		Vendedor vendedor = vd.encontraId(3);
		System.out.println(vendedor);
		
		System.out.println("\n=== Teste 1: Vendedor encontraDepartamento ====");
		Departamento departamento = new Departamento(2, null);
		List<Vendedor> lista = vd.EncontraDepartamento(departamento);
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
	}
}

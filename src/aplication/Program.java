package aplication;

import java.util.Date;
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
		List<Vendedor> lista = vd.encontraDepartamento(departamento);
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 3: Vendedor encontraDepartamento ====");
		lista = vd.encontraTodos();
		for(Vendedor obj : lista) {
			System.out.println(obj);
		}
		
		System.out.println("\n=== Teste 4: Vendedor inserir ====");
		Vendedor novoVendedor = new Vendedor(null, "Greg", "grege@gmail.com", new Date(), 4000.0, departamento);
		vd.inserir(novoVendedor);
		System.out.println("Inserido! novo id = "+novoVendedor.getId());
	}
}

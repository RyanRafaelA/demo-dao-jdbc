package aplication;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import model.dao.FabricaDao;
import model.dao.VendedorDao;
import model.entities.Departamento;

public class Program {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
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
		
		System.out.println("\n=== Teste 5: Vendedor atualizar ====");
		vendedor = vd.encontraId(1);
		vendedor.setNome("Martha Waine");
		vd.atualizar(vendedor);
		System.out.println("Atualização completa!");
		
		System.out.println("\n=== Teste 6: Vendedor removido ====");
		System.out.print("Entre com um id para o teste de deleção: ");
		int id = sc.nextInt();
		vd.deletarId(id);
		System.out.println("Deletado");
		
		sc.close();
	}
}

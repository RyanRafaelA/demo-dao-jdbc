package aplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entities.Departamento;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<Departamento> lista = new ArrayList<>();
		DepartamentoDao dp = FabricaDao.crearDepartamentoDao();
		
		System.out.println("=====  Teste 1 : Departamento -> EncontraId =====");
		System.out.print("Digite o id de um departamento: ");
		Departamento departamento = dp.encontraId(sc.nextInt());
		System.out.println(departamento);
		
		System.out.println("\n==== Teste 2 : Departamento -> EncontraTodos ====");
		lista=dp.encontraTodos();
		for(Departamento dee : lista) {
			System.out.println(dee);
		}
			
		System.out.println("\n==== Teste 3: Departamento -> inserir ===");
		departamento = new Departamento(null, "Comida");
		dp.inserir(departamento);
		System.out.println("Inseriu um novo departameto, com Id: "+departamento.getId());
		
		System.out.println("\n=== Teste 4: Departamento -> atualizar ===");
		departamento = dp.encontraId(3);
		departamento.setNome("Musica");
		dp.atualizar(departamento);
		System.out.println("Atualização completa!");
		
		
		sc.close();
	}

}

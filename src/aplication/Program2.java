package aplication;

import java.util.Scanner;

import model.dao.DepartamentoDao;
import model.dao.FabricaDao;
import model.entities.Departamento;

public class Program2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DepartamentoDao dp = FabricaDao.crearDepartamentoDao();
		
		System.out.println("====  Teste 1 : Departamento EncontraId =====");
		System.out.print("Digite um id de um departamento: ");
		Departamento d = dp.encontraId(sc.nextInt());
		System.out.println(d);
		
		
		
		
		
		sc.close();
	}

}

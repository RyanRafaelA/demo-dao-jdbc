package model.dao;

import java.util.List;

import aplication.Vendedor;
import model.entities.Departamento;

public interface VendedorDao {
	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void deletarId(Integer id);
	Vendedor encontraId(Integer id);
	List<Vendedor> encontraTodos();
	List<Vendedor> EncontraDepartamento(Departamento departamento);
}

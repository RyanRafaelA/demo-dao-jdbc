package model.dao;

import java.util.List;

import aplication.Vendedor;

public interface VendedorDao {
	void inserir(Vendedor obj);
	void atualizar(Vendedor obj);
	void deletarId(Integer id);
	Vendedor encontraId(Integer id);
	List<Vendedor> encontraTodos();
}

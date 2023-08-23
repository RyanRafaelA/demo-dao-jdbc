package model.dao;

import java.util.List;

import model.entities.Departamento;

public interface DepartamentoDao {
	void inserir(Departamento obj);
	void atualizar(Departamento obj);
	void deletarId(Integer id);
	Departamento encontraId(Integer id);
	List<Departamento> encontraTodos();
}

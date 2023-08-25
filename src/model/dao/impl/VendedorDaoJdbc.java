package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import aplication.Vendedor;
import db.DB;
import db.DbException;
import model.dao.VendedorDao;
import model.entities.Departamento;

public class VendedorDaoJdbc implements VendedorDao{
	private Connection conn;
	
	public VendedorDaoJdbc(Connection conn) {
		this.conn = conn;
	}
	
	
	@Override
	public void inserir(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atualizar(Vendedor obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Vendedor encontraId(Integer id) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName"
					+"\nFROM seller INNER JOIN department"
					+"\nON seller.DepartmentId = department.Id"
					+"\nWHERE seller.Id = ?");
			
			st.setInt(1, id);
			rs=st.executeQuery();
			if(rs.next()) {
				Departamento dep = instanciaDepartamento(rs);
				Vendedor obj = instanciaVendedor(rs, dep);
				
				return obj;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	private Vendedor instanciaVendedor(ResultSet rs, Departamento dep) throws SQLException {
		Vendedor obj = new Vendedor();
		obj.setId(rs.getInt("Id"));
		obj.setNome(rs.getString("Name"));
		obj.setEmail(rs.getString("Email"));
		obj.setSalarioBase(rs.getDouble("BaseSalary"));
		obj.setDataNascimento(rs.getDate("BirthDate"));
		obj.setDepartamento(dep);
		
		return obj;
	}


	private Departamento instanciaDepartamento(ResultSet rs) throws SQLException {
		Departamento dep = new Departamento();
		dep.setId(rs.getInt("DepartmentId"));
		dep.setNome(rs.getString("DepName"));
		
		return dep;
	}


	@Override
	public List<Vendedor> encontraTodos() {
		PreparedStatement st = null;
		ResultSet rs = null;
		try{
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName"
					+"\nFROM seller INNER JOIN department"
					+"\nON seller.DepartmentId = department.Id"
					+"\nORDER BY Name");
			
			rs=st.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while(rs.next()) {
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Vendedor obj = instanciaVendedor(rs, dep);
				lista.add(obj);
			}
			return lista;
			
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}


	@Override
	public List<Vendedor> encontraDepartamento(Departamento departamento) {
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(
					"SELECT seller.*, department.Name as DepName"
					+"\nFROM seller INNER JOIN department"
					+"\nON seller.DepartmentId = department.Id"
					+"\nWHERE DepartmentId= ?"
					+"\nORDER BY Name");
			
			st.setInt(1, departamento.getId());
			rs=st.executeQuery();
			
			List<Vendedor> lista = new ArrayList<>();
			Map<Integer, Departamento> map = new HashMap<>();
			
			while(rs.next()) {
				Departamento dep = map.get(rs.getInt("DepartmentId"));
				
				if(dep == null) {
					dep = instanciaDepartamento(rs);
					map.put(rs.getInt("DepartmentId"), dep);
				}
				
				Vendedor obj = instanciaVendedor(rs, dep);
				lista.add(obj);
			}
			return lista;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}
	

}

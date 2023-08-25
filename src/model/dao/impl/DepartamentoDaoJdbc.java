package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import db.DbException;
import model.dao.DepartamentoDao;
import model.entities.Departamento;

public class DepartamentoDaoJdbc implements DepartamentoDao{
	Connection conn = null;
	
	public DepartamentoDaoJdbc(Connection conn) {
		this.conn = conn;
	}

	@Override
	public void inserir(Departamento obj) {
		PreparedStatement ps = null;
		
		
	}

	@Override
	public void atualizar(Departamento obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletarId(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Departamento encontraId(Integer id) {
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			ps = conn.prepareStatement(	"SELECT * From Department"
					+"\nWHERE Department.Id = ?" );
			
			ps.setInt(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				Departamento dep = new Departamento();
				dep.setNome(rs.getString("Name"));
				dep.setId(rs.getInt("Id"));
				
				return dep;
			}
			return null;
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Departamento> encontraTodos() {
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			ps = conn.prepareStatement(	"SELECT * from Department" );
			rs = ps.executeQuery();
			
			List<Departamento> lista = new ArrayList<>(); 
			
			while(rs.next()) {
				Departamento dep = new Departamento();
				dep.setNome(rs.getString("Name"));
				dep.setId(rs.getInt("Id"));
				
				lista.add(dep);
			}
			return lista;
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeResultSet(rs);
			DB.closeStatement(ps);
		}
	}

}

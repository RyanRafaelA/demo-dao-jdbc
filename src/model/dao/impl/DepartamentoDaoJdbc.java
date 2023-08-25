package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
		// TODO Auto-generated method stub
		
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
		PreparedStatement st = null;
		ResultSet rs = null;
		
		try {
			st = conn.prepareStatement(	"SELECT * From Department"
					+"\nWHERE Department.Id = ?" );
			
			st.setInt(1, id);
			rs=st.executeQuery();
			
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
			DB.closeStatement(st);
			DB.closeResultSet(rs);
		}
	}

	@Override
	public List<Departamento> encontraTodos() {
		// TODO Auto-generated method stub
		return null;
	}

}

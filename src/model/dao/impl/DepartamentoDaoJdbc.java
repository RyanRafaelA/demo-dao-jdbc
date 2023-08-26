package model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
		try {
			ps = conn.prepareStatement( "INSERT INTO Department"
										+"\n(Name)"
										+"\nVALUES"
										+"\n(?)",
										Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, obj.getNome());
			
			int linhasAfetadas = ps.executeUpdate();
			
			if(linhasAfetadas > 0) {
				ResultSet rs = ps.getGeneratedKeys();
				if(rs.next()) {
					int id = rs.getInt(1);
					obj.setId(id);
				}
				DB.closeResultSet(rs);
			} else {
				throw new DbException("Erro! Nenhuma linhas foi afetada!");
			}
			
		}
		catch(SQLException e){
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
	}

	@Override
	public void atualizar(Departamento obj) {
		PreparedStatement ps  = null;
		try {
			ps = conn.prepareStatement( "UPDATE Department"
										+"\nSET Name = ?"
										+"\nWHERE ID = ?" );
			ps.setString(1, obj.getNome());
			ps.setInt(2, obj.getId());
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
		
	}

	@Override
	public void deletarId(Integer id) {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(	"DELETE FROM Department WHERE Id = ?" );
			
			ps.setInt(1, id);
			
			ps.executeUpdate();
		}
		catch(SQLException e) {
			throw new DbException(e.getMessage());
		}
		finally {
			DB.closeStatement(ps);
		}
		
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

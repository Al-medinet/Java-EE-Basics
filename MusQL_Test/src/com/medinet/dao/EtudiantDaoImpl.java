package com.medinet.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Collection;

import com.medinet.model.Etudiant;

public class EtudiantDaoImpl implements IEtudiant{

	@Override
	public boolean save(Etudiant e) {
		try{
			Connection cnx=AccessDB.getInstance().getConnection();
			PreparedStatement prepare=cnx.prepareStatement("INSERT INTO Etudiant Values(?,?,?)");
			prepare.setInt(1, e.getCode());
			prepare.setString(2, e.getNom());
			prepare.setString(3, e.getPrenom());
			boolean stat=prepare.execute();
			return stat;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean update(Etudiant e) {
		try{
			Connection cnx=AccessDB.getInstance().getConnection();
			PreparedStatement prepare=cnx.prepareStatement("UPDATE Etudiant set nom=?,prenom=? WHERE code=?");
			prepare.setString(1, e.getNom());
			prepare.setString(2, e.getPrenom());
			prepare.setInt(3, e.getCode());
			boolean stat=prepare.execute();
			return stat;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return false;
	}

	@Override
	public Etudiant delete(int code) {
		try{
			Connection cnx=AccessDB.getInstance().getConnection();
			PreparedStatement prepare=cnx.prepareStatement("DELETE FROM Etudiant WHERE code=?");
			prepare.setInt(1, code);
			Etudiant e=findOne(code);
			boolean stat=prepare.execute();
			return e;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

	@Override
	public Etudiant findOne(int code) {
		Etudiant e=null;
		try{
			Connection cnx=AccessDB.getInstance().getConnection();
			PreparedStatement prepare=cnx.prepareStatement("SELECT * FROM Etudiant WHERE code=?");
			prepare.setInt(1, code);
			ResultSet rs=prepare.executeQuery();
			rs.next();
			e=new Etudiant(rs.getInt("code"),rs.getString("nom"),rs.getString("prenom"));
			return e;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return e;
	}

	@Override
	public Collection<Etudiant> findAll() {
		try{
			Connection cnx=AccessDB.getInstance().getConnection();
			PreparedStatement prepare=cnx.prepareStatement("SELECT * FROM Etudiant");
			ResultSet rs=prepare.executeQuery();
			Collection<Etudiant> lists=new ArrayList<Etudiant>();
			while(rs.next())
			{
				Etudiant e=new Etudiant(rs.getInt("code"),rs.getString("nom"),rs.getString("prenom"));
				lists.add(e);
			}
			return lists;
		}catch(Exception ex)
		{
			System.out.println(ex.getMessage());
		}
		return null;
	}

}

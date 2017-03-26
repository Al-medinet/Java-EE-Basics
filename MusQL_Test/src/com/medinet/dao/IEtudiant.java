package com.medinet.dao;

import java.util.Collection;

import com.medinet.model.Etudiant;
public interface IEtudiant {

	public boolean save(Etudiant e);
	public boolean update(Etudiant e);
	public Etudiant delete(int code);
	public Etudiant findOne(int code);
	public Collection<Etudiant> findAll();
}

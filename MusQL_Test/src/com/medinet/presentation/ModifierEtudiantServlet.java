package com.medinet.presentation;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medinet.dao.EtudiantDaoImpl;
import com.medinet.dao.IEtudiant;
import com.medinet.model.Etudiant;

/**
 * Servlet implementation class ModifierEtudiantServlet
 */
@WebServlet({ "/ModifierEtudiant", "/modifier" })
public class ModifierEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEtudiant metier;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierEtudiantServlet() {
        super();
        metier=new EtudiantDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code=Integer.parseInt(request.getParameter("code"));
		Etudiant etudiant=metier.findOne(code);
		request.setAttribute("etudiant", etudiant);
		request.getRequestDispatcher("ModifierEtudiant.jsp").forward(request, response);	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int code=Integer.valueOf(request.getParameter("code"));
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		Etudiant e=new Etudiant(code,nom,prenom);
		boolean stat=metier.update(e);
		request.getRequestDispatcher("/").forward(request, response);
	}

}

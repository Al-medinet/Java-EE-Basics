package com.medinet.presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.medinet.dao.EtudiantDaoImpl;
import com.medinet.dao.IEtudiant;
import com.medinet.model.Etudiant;

/**
 * Servlet implementation class DeleteEtudiantServlet
 */
@WebServlet({ "/DeleteEtudiant", "/delete" })
public class DeleteEtudiantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private IEtudiant metier;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteEtudiantServlet() {
        super();
        metier=new EtudiantDaoImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Etudiant etudiant=null;
		int code=Integer.parseInt(request.getParameter("code"));
		etudiant=metier.delete(code);
		request.setAttribute("etudiant", etudiant);
		request.getRequestDispatcher("/").forward(request, response);
	}

}

import java.util.Collection;

import com.medinet.dao.EtudiantDaoImpl;
import com.medinet.dao.IEtudiant;
import com.medinet.model.Etudiant;

public class Test {

	public static void main(String[] args) {

		IEtudiant metier=new EtudiantDaoImpl();
		/*metier.save(new Etudiant(12, "jemhour", "Mehdi"));
		metier.save(new Etudiant(13, "Aradi", "El Mehdi"));
		metier.save(new Etudiant(14, "Rachid", "Chems"));
		metier.save(new Etudiant(15, "Abdelhadi", "Sarhan"));*/
		
		Collection<Etudiant> lists=metier.findAll();
		for(Etudiant etudiant:lists)
		{
			System.out.println("Code Etudiant : \t"+etudiant.getCode()+"\t Nom : \t"+etudiant.getNom()+"\t Prenom : \t"+etudiant.getPrenom());
		}
		Etudiant etudiant=metier.findOne(15);
		System.out.println("+---------------------------------------------+");
		System.out.println("Code Etudiant : \t"+etudiant.getCode()+"\t Nom : \t"+etudiant.getNom()+"\t Prenom : "+etudiant.getPrenom());
	}

}

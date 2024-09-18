// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Compteur.java                                      :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: iyan nazarian								+#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/04/29 20:22:29 by iyan nazarian     #+#    #+#             //
//   Updated: 2024/04/30 14:33:47 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class Compteur {
	private int kilometrage_total; // in km/h
	private int	kilometrage_LOC; // LOC = Last Oil Change
	private int	vitesse; // in km/h
	private int	acceleration;
	private static String marque;

	public void resetKilometrageLOC() {
		kilometrage_LOC = 0;
	}

	public void revisionWarning() {
		if (kilometrage_total % 10_000) {
			System.out.println("WARNING : 10 000 km done, need a revision");
		}
	}

	public void changeBrand(String new_brand) {
		marque = new_brand;
	}

	public void tempsPasser() {
		int temps_total = kilometrage_total / vitesse;
		System.out.println("Le temps total a " + vitesse + " km/h est " + temps_total + " heures.");
	}	

		

//+--------+--------------------------------------------------------------------+
//| Numero |                            Expliquation                            |
//+--------+--------------------------------------------------------------------+
//| D1     | attribut vitesse sert a sa                                         |
//| D2     | l'acceleration ?? j'ai pas vraiment compris la formulation...      |
//| D3     | methode qui reinitialise le compteur                               |
//| D4     | Bah methode qui divise le kilometrage par la vitesse je suppose    |
//| D5     | methode qui fait sa                                                |
//| D6     | rendre lattribut marque static, et faire une methode qui le change |
//+--------+--------------------------------------------------------------------+


}

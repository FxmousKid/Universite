// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   Cellule.java                                       :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: iyan nazarian								+#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/04/29 20:22:29 by iyan nazarian     #+#    #+#             //
//   Updated: 2024/04/30 15:19:44 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class Cellule {

	private String nom;
	private Cellule next;
	private Cellule prev;

	public void Queue(String nom) {
		this.nom = nom;
		this.next = null;
		this.prev = null;
	}
	
	public void addFirst(String nom) {
		Cellule newCell = new Cellule(nom);
		newCell.next = this;
		this.prev = newCell;
	}

	public void addLast(String nom) {
		Cellule newCell = new Cellule(nom);
		Cellule tmp = this;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		tmp.next = newCell;
		newCell.prev = tmp;
	}
}

// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   exercice2.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/09/19 12:52:13 by inazaria          #+#    #+#             //
//   Updated: 2024/09/19 15:00:16 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class exercice2 {
	public static void main(String args[]) {
		int[] t = {1, 2, 3, 4, 5};
		System.out.println("Test de la fonction Max2 :");

		System.out.print("t = ");
		printArray(t);
		System.out.println("Max2 = " + Max2(t));
	}


	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length - 1] + "]");
	}



	public static int Max2(int[] t) {
		int max, max2;
		if (t[0] > t[1]) {
			max = t[0];
			max2 = t[1];
		}
		else {
			max = t[1];
			max2 = t[0];
		}

		// for (int i = 2; i < t.length - 2; i++) {		
		for (int i = 2; i < t.length; i++) {
			if (t[i] > max) {
				max2 = max;
				max = t[i];
			}
			else {
				if (t[i] > max2 && t[i] < max) {
						max2 = t[i];
				}
			}
		}
		return max2;
	}
}

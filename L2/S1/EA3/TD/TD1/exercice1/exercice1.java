// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   exercice1.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/09/19 12:40:01 by inazaria          #+#    #+#             //
//   Updated: 2024/09/19 12:51:44 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class exercice1 {
	public static void main(String args[]) {
		int[] tab = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		printArray(tab);
		fonc(tab);
		printArray(tab);
		foncInverse(tab);
		printArray(tab);

	}

	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length - 1] + "]");
	}

	public static void fonc(int[] t) {
		for (int i = 0; i < t.length - 1; i++) {
			t[i + 1] = t[i + 1] + t[i];
		}
	}

	public static void foncInverse(int[] t) {
		
		for (int i = t.length - 1; i > 0; i--) {
			t[i] = t[i] - t[i - 1];
		}

	}

}

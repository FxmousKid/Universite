// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   exercice2.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/09/19 11:38:00 by inazaria          #+#    #+#             //
//   Updated: 2024/09/19 11:59:58 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class exercice2 {

	public static void main(String args[]) {
		printArray(new int[] {1, 2, 3, 4, 5});	
	}

	public static void printArray(int[] array) {
		System.out.print("Array: [");
		for (int i = 0; i < array.length - 1; i++) {
			System.out.print(array[i] + ", ");
		}
		System.out.println(array[array.length - 1] + "]");
	}


}

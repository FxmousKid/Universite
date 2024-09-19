// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   exercice4.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/09/19 15:34:06 by inazaria          #+#    #+#             //
//   Updated: 2024/09/19 15:56:40 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class exercice4 {
	public static void main(String args[]) {
		String mot1 = "Hello";
		String mot2 = "Hellp";
		System.out.println("strcmp(" + mot1 + ", " + mot2 + ") = " + strcmp(mot1, mot2));
		String[] words = {"ab", "ac", "aa", "az"};
		System.out.println("Smallest word of array = " + min(words));

		
	}

	public static int strcmp(String mot1, String mot2) {
		int i = 0;
		int len1 = mot1.length();
		int len2 = mot2.length();
		
		while (i < len1 && i < len2 && mot1.charAt(i) == mot2.charAt(i)) {
			i++;
		}
		if (i == len1 && i == len2) {
			return (0);
		}
		if (i == len1) {
			return (-1);
		}
		if (i == len2) {
			return (1);
		}
		return (mot1.charAt(i) - mot2.charAt(i));
	}

	public static String min(String[] words) {
		String min = words[0];
		for (int i = 1; i < words.length; i++) {
			if (strcmp(min, words[i]) > 0)
				min = words[i];	
		}
		return (min);
	}
}

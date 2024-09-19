// ************************************************************************** //
//                                                                            //
//                                                        :::      ::::::::   //
//   exercice3.java                                     :+:      :+:    :+:   //
//                                                    +:+ +:+         +:+     //
//   By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+        //
//                                                +#+#+#+#+#+   +#+           //
//   Created: 2024/09/19 15:01:21 by inazaria          #+#    #+#             //
//   Updated: 2024/09/19 15:33:37 by inazaria         ###   ########.fr       //
//                                                                            //
// ************************************************************************** //

public class exercice3 {
	public static void main(String args[]) {
		int[] t = {1,2,3,4,5};
		int[] answer = MinMax(t);
		System.out.println("Test MinMax() :");
		System.out.println("Min = " + answer[0] + ", Max = " + answer[1]);
		System.out.println("Test MinMaxEfficace() :");
		answer = MinMaxEfficace(t);
		System.out.println("Min = " + answer[0] + ", Max = " + answer[1]);

	}

	public static void printArray(int[] arr) {
		System.out.print("[");
		for (int i = 0; i < arr.length - 1; i++) {
			System.out.print(arr[i] + ", ");
		}
		System.out.println(arr[arr.length - 1] + "]");
	}

	public static int[] MinMax(int[] t) {
		int max = t[0];
		int min = t[0];
		for (int i = 1; i < t.length; i++) {
			if (min < t[i]) {
				min = t[i];
			}
			else if (min > t[i]) {
				max = t[i];
			}
		}
		int[] answer = {max, min};
		return (answer); 
	}

	public static int[] MinMaxEfficace(int[] t) {
		int min = t[0];
		int max = t[1];
		int k = t.length % 2;

		for (int i = k; i < t.length; i++) {
			if (t[i] > t[i - 1]) {
				if (t[i] > max) {
					max = t[i];
				}
				if (t[i - 1] < min) {
					min = t[i - 1];
				}
			}
			else {
				if (t[i] < min) {
					min = t[i];
				}
				if (t[i - 1] > max) {
					max = t[i - 1];
				}
			}
		}
		int[] answer = {min, max};
		return (answer);
	}
}

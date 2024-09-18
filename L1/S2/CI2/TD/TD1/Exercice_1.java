package CI2.TD.TD1;

import java.util.Stack;

class Exercice_1 {
    
    public static void afficher(Stack<Integer> p) {
        Stack<Integer> q = new Stack<Integer>();

        while (!p.empty()) {
            int a = p.pop();
            q.push(a);
            System.out.println(a);
        }

        while (!q.empty()) {
            p.push(q.pop());
        }
    }

    public static void transverser(Stack<Integer> p, Stack<Integer> q) {
        while (!p.empty()) {
            int a = p.pop();
            q.push(a);
        }
    }

}
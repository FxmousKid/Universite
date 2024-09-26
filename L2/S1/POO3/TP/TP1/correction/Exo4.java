import java.util.Random;
import java.util.Scanner;

public class Exo4{
    
    public static Scanner sc;
    
    /* Partie 1 de l'exercice 4 */
    public static int question(int maxTentatives){
        
        // compteur pour le nombre d'erreurs de l'utilisateur
        int nbErreurs = 0;
        boolean trouve = false;
        
        Random rd = new Random();
        int n1 = 1 + rd.nextInt(9);
        int n2 = 1 + rd.nextInt(9);
        
        while(!trouve && (nbErreurs < maxTentatives)){
            System.out.print("Donnez le produit de "+n1+" et = "+n2+" : ");
            //lecture de la reponse
            int reponse = sc.nextInt();
            if(reponse != n1*n2){
                nbErreurs ++;
            }
            else trouve = true;
        }
        
        return nbErreurs;
    }
    
    
    /* Partie 2 de l'exercice 4 */
    public static int evaluation(int n){
        
        int score = n;
        int questionsRestantes = n;
        
        while(questionsRestantes > 0){
            int nbErreurs = question(questionsRestantes);
            score -= nbErreurs;
            questionsRestantes -= nbErreurs + 1;
        }
        
        return (score > 0) ? score : 0;
    }
    
    public static void main(String[] args){
        
        sc = new Scanner(System.in);
        // Partie 1
        //System.out.println("Le nombre de fausses réponses est  "+question(3));
        
        //Partie 2
        int nbQuestions = 5;
        System.out.println("Score: " + String.valueOf(evaluation(nbQuestions)) + "/" + String.valueOf(nbQuestions));
        
        sc.close();
    }
}

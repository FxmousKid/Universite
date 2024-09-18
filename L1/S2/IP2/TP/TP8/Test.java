public class Test {
	
	public static void main(String[] args) {
		
		Robot rob = new Robot('A', "Coucou moi c'est john");
		TableRonde tabl = new TableRonde(rob);	
		tabl.ajouteRob(new Robot('B', "Miaou"));
		tabl.ajouteRob(new Robot('C', "Waf"));
		tabl.affiche();
		System.out.println("\n\n");
		tabl.supprimer(2);
		tabl.affiche();
		tabl.supprimer('C');	
		System.out.println("\n\n");
		tabl.affiche();
	}
}

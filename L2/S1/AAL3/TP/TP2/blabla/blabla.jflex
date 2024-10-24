%%
%public
%class Lexer  //générera le fichier Lexer.java
%unicode
%standalone


%{
//éventuellement code java qui sera recopié au début de du lexer généré
	public int compteBlabla = 0;
	public int compteMoustique = 0;
	public int longeurTotalMoustique = 0;

%}

//définition d'expressions régulières

moustique = z+


%{eof
   //éventuellement code java qui sera recopié en fin du lexer généré
   System.out.println("\nnombre de blabla = "+ compteBlabla);
   int moyenne = longeurTotalMoustique / compteMoustique;
   System.out.println("Longeur moyenne d'une serie de z est : " + moyenne);
%eof}

%%

//les règles:

bla(bla)+      
{
	compteBlabla++;           
	System.out.println(yytext() + ": " + compteBlabla);
}

{moustique}     
{
    System.out.println("il y a un moustique! (longueur: " + yylength() + ")");
	compteMoustique++;
	longeurTotalMoustique += yylength();
}

[^]	{}

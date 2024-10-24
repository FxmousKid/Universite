%%
%public
%class Lexer
%unicode
%standalone

%{
	public int count = 0;
	public int totalValue = 0;
%}

chiffre = [0-9]


%{eof
	System.out.println("nombre de chiffres = "+ count);
%eof}

%%
{chiffre}     {count++; totalValue += chiffre += Integer.parseInt(yytext());}
[^]           {}


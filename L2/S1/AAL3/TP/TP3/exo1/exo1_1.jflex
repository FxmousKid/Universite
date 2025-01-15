%%
%class ex1_1
%standalone

voyelle = [aeiouyAEIOUY]
consonne = [b-df-hj-np-tv-xzB-DF-HJ-NP-TV-XZ]

%%

[A-Z][a-zA-Z]*
{
    System.out.println(yytext());
}

[^] {}

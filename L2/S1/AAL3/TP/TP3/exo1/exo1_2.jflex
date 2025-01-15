%%
%class ex1_2
%standalone

voyelle = [aeiouyAEIOUY]
non_voyelle = [^aeiouyAEIOUY]
consonne = [b-df-hj-np-tv-xzB-DF-HJ-NP-TV-XZ]

%%

\w*{non_voyelle}*{voyelle}{non_voyelle}*\w*
{
    System.out.println(yytext());
}


[^] {}

%%
%public
%class Lexer
%unicode
%standalone

%{
%}

%{eof
%eof}






// on attend ici un "nom" le plus explicite/signifiant possible
// pour chacun de vos états; donc pas du tout comme ceux-là:
//%state MON_ETAT, ENCORE_UN, ET_PUIS_UN_AUTRE, ETC

%%
<YYINITIAL> {
    [^] {}
}




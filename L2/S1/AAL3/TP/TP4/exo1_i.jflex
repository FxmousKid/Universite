%%
%public
%class Lexer
%unicode
%standalone

%{
  private String cut(String s, int col){
     String[] sSplit = s.split(";");
     return(sSplit[col]);
  }
%}

%{eof

%eof}



%%


[^] {} 
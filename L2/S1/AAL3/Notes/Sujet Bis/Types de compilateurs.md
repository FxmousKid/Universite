
On distingue 2 types de compilateurs, baser sur leur nombre de *passes*, qui fait reference au nombre de fois ou le compilateur traverse un fichier générer par la compilation
## Compilateur a une passe

Celui-ci fait la phase lexicale : <u>scanning</u> / lexing (analyse lexicale) , <u>parsing</u> (analyse syntaxique, et <u>verification sémantique</u> (verification des types, etc...) avec **une seule traverse de code source** et ne génère pas de **fichier intermédiaire**. 
Cela implique :
- 👎 <u>Difficulté</u> d'optimiser le code
- 👎 Plus de chance de causer une erreur d'<u>execution</u> que de compilation
- 👍 Offre une compilation <u>rapide</u>
- 👍 Prendre <u>peu</u> de mémoire
- 🫰 Est généralement utiliser pour des languages considérés "<u>non-complexes</u>".<u></u>

On peut observer le compilateur TurboPascal, ou des compilateurs ancien de Fortran.
## Compilateur a plusieurs passe

Ce type de compilateur peut par exemple créer un fichier générer par l'analyse lexicale qui contient les lexèmes dans un ordre spécifiques.
Puis le parsing se base sur ce fichier pour sortir un autre fichier qui contient *[[l'arbre syntaxique]]* , etc...  Cela résulte donc en **plusieurs traverser de code source** et génère plusieurs **fichiers temporaires**.
Cela implique :
- 👍 Une <u>bonne</u> optimization du code
- 👍 La majorité des erreurs sont des erreurs de <u>compilation</u>.
- 👎 Est assez <u>lent</u> en terme de generation du code final
- 👎 Prend pas mal d'espace mémoire.
- 🫰 Est généralement utiliser pour des languages considérés "<u>complexes</u>".

On peut observer des compilateurs comme GCC, clang, LLVM...

## Compilateur a 2 passes

Les Compilateur a 2 passes sont les plus populaires, ils fonctionnent en faisant une phase d'analyse en 1 passe et en faisant une phase de production en 1 passe.

La 1ere phase génère une **Representation Intermédiaire**, qui est utiliser afin d’être optimizer, et puis la phase de production l'utilise afin de générer le code final.
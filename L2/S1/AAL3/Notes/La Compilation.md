
**La** compilation est le processus de traduction entre un language de haut niveau en un [[language de bas niveau]] 

La *Compilation* d'un program se fait en 2 phases : La ==phase d'analyse== et la ==phase de production==, mais peut être fait en [[Types de compilateurs|plusieurs ou une passe]]


### La phase d'analyse

Il, [le compilateur] vérifie si le code source est conforme a la *grammaire* et la *syntax* du language.
Cette phase se déroule en 3 étapes :

- *[[L'analyse lexicale]]* : Verifies que tout les mots du code source appartienne au languages (les lexèmes) (ex: que le '+' sont un lexème). Cette partie est aussi responsable de générer des **jetons** qui font généralement partie d'un *[[Language régulier]]*

- <u>L'analyse syntaxique</u> : Retrouve les relations entre les lexèmes et forme *[[l'arbre syntaxique]]*, vérifie aussi que les règles syntaxique sont respecter. (ex: un opérateur binaire a bel et bien 2 operands)

-  <u>L'analyse sémantique</u> : Donne une signification a *[[l'arbre syntaxique]]*, vérifie que les règles de typages sont bien respecter par exemple.

### La phase de production

Cette phase est plus complique, vu que c'est la que les compilateur commence a différer l'un de l'autre, mais voila les étapes communes :

-  <u>Generation d'un code intermédiaire</u> (OPTIONNEL) :  Cette phase permet de ne pas tenir compte des contraintes matérielle comme différentes architecture, et ce code la est interne au compilateur, il s'execute généralement dans la *Machine Virtuelle* de ce language :(Python, Java).

- <u>Optimisation</u> : un code sera souvent optimiser avant d’être execute, comme éliminer du code mort (dead code elimination), fusionner 2 boules similaires (loop fusion).

- <u>Generation d'un code final</u> (Executable) : Applique la dernière étape du compilateur, peut être faire le lien entre les fichiers objects. Normalement gene du code machine executable sur une architecture spécifique, dépendamment de la complexité du code.

## Outils théoriques et pratiques


| Phases de la compilation            | Outils Thoeriques                              |            Outils pratiques            |
| ----------------------------------- | ---------------------------------------------- | :------------------------------------: |
| Analyse lexicale (lexing, scanning) | Expressions régulière, Automates a états finis | Java, Ruby, C, (F)lex, JavaCC, SableCC |
| Analyse syntaxique (parsing)        | Grammaires                                     |      Yacc, Bison, JavaCC, SableCC      |
| Analyse semantique                  | Traduction dirigée par la syntaxe              |              ' ' ' ' ' '               |

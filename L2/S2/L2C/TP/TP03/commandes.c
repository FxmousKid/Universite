#include <stdio.h> 
#include <stdlib.h>
#include <time.h>

#define YLW "\e[33m"
#define END "\e[0m"

#ifndef NBC
# define NBC 20
#endif

typedef enum e_etat {
	VALIDEE		= 0,
	ENCOURS		= 1,
	EXPEDIEE	= 2
}	t_etat;

t_etat	get_rand_etat()
{
	return (rand() % 3);
}

typedef struct s_commande {
	int		num_com;
	int		prix_exp;
	int		prix_prod;
	t_etat	etat;
}			t_commande;	

t_commande	com_alea(int num)
{
	t_commande	com;

	com.num_com = num;
	com.prix_exp = rand() % 21;
	com.prix_prod = rand() % 2001;
	com.etat =	get_rand_etat();
	return (com);
}

void	affiche_com(t_commande c)
{
	printf("%sCommande: [%s", YLW, END);
	printf("Num: %d, ", c.num_com);
	printf("Prix exp: %d, ", c.prix_exp);
	printf("Prix prod: %d, ", c.prix_prod);
	printf("Etat: ");
	switch (c.etat) {
		case VALIDEE:
			printf("Validée");
			break;
		case ENCOURS:
			printf("En cours");
			break;
		case EXPEDIEE:
			printf("Expédiée");
			break;
	}
	printf("%s]\n%s", YLW, END);
}

void	affiche_cmd_if_etat(t_commande tab[], size_t size, t_etat etat)
{
	int	idx = -1;

	while ((size_t) ++idx < size) 
		tab[idx].etat == etat ? affiche_com(tab[idx]) : (void) size;
}


/* Afin de pouvoir changer le prix, faut passer l'addrese de l'object
 * concerner et non l'object lui meme, par convention C passe une copie... 
 * principe idempotent en C, changer la valeur d'un object ? passer son addresse
 * changer la valeur d'un pointeur (a quelle addr il pointe) ? passer son addresse
 * ...*/
void	changer_prix(t_commande *com, long int newprix)
{
	com->prix_prod = newprix;
}


/* Voila expedie_tout(), on peut passer un t_commande[] vu que derriere,
 * un t_commande[] automatically decays into a t_commande.
 * (desoler pour le mix anglais francais, mais je prefere etre precis)
 */
void	expedie_tout(t_commande tab[], size_t size)
{
	size_t	idx = 0;

	while (idx < size)
		tab[idx++].etat = EXPEDIEE;
}

int main(void)
{
	t_commande	c2 = {1, 10, 20, VALIDEE};
	(void) c2; // For compiler Warning
	t_commande	c1;
	c1.num_com = 0;	
	c1.prix_prod = 10;
	c1.etat = EXPEDIEE;
	(void) c1;
	
	srand(time(NULL));

	t_commande	tab[NBC];
	int			idx = -1;

	while (++idx < NBC)
		tab[idx] = com_alea(idx);

	printf("\nCOMMAND QUI SONT EXPEDIER\n");
	affiche_cmd_if_etat(tab, NBC, EXPEDIEE);
	printf("\nCOMMAND QUI SONT EN COURS\n");
	affiche_cmd_if_etat(tab, NBC, ENCOURS);
	printf("\nCOMMAND QUI SONT VALIDEE\n");
	affiche_cmd_if_etat(tab, NBC, VALIDEE);
	
	// expedie_tout(tab, NBC);
	// printf("\nCOMMAND QUI SONT EXPEDIER\n");
	// affiche_cmd_if_etat(tab, NBC, EXPEDIEE);

}

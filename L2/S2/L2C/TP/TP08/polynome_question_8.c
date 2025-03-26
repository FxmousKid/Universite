#include <stdio.h>
#include <stdlib.h>

typedef struct s_maillon 
{
	int					coef;
	int					degree;
	struct s_maillon	*suiv;
}						t_maillon;

t_maillon	*creer_monome(int coef, int deg)
{
	t_maillon	*maillon = calloc(1, sizeof(t_maillon));
	if (!maillon)
		return (perror("calloc"), NULL);
	maillon->coef = coef;
	maillon->degree = deg;
	return (maillon);
}

void	liberer(t_maillon *p)
{
	t_maillon *tmp;
	while (p)
	{
		tmp = p;
		p = p->suiv;
		free(tmp);
	}
}

double	powd(double x, double y)
{
	if (x == 1 || y == 0)
		return (1);
	int tmp = x;
	while (y-- >= 0)
		x *= tmp;
	return (x);
}

double	evaluer_polynome(t_maillon *p, double x)
{
	double res = 0;
	
	while (p)
	{
		res += p->coef * powd(x, p->degree);
		p = p->suiv;
	}
	return (res);
}

void	affiche_polynome(t_maillon *p)
{
	while (p)
	{
		printf("%d * x^%d", p->coef, p->degree);
		if (p->suiv)
			printf(" + ");
		p = p->suiv;
	}
	printf("\n");
}

t_maillon	*ajoute_monome(t_maillon *p, int coef, int deg)
{
	t_maillon	*tmp = p;
	while (tmp)
	{
		if (tmp->degree == deg)
			return (tmp->coef += coef, p);
		tmp = tmp->suiv;
	}
	t_maillon *new = calloc(1, sizeof(t_maillon));
	if (!new)
		return (perror("calloc"), NULL);
	new->coef = coef;
	new->degree = deg;
	if (!p || p->degree > deg)
		return (new->suiv = p, new);
	tmp = p;
	while (tmp->suiv)
		tmp = tmp->suiv;
	tmp->suiv = new;
	return (p);
}

t_maillon	*copie(t_maillon *p)
{
	t_maillon *new = NULL;
	t_maillon *tmp = p;
	while (tmp)
	{
		new = ajoute_monome(new, tmp->coef, tmp->degree);
		tmp = tmp->suiv;
	}
	return (new);
}

t_maillon	*somme(t_maillon *p, t_maillon *q)
{
	t_maillon *new;

	if (!p)
		return (copie(q));
	if (!q)
		return (copie(p));

	if (p->degree > q->degree)
	{
		new = creer_monome(p->coef, p->degree);
		new->suiv = somme(p->suiv, q);
	}
	else if (p->degree < q->degree)
	{
		new = creer_monome(q->coef, q->degree);
		new->suiv = somme(p, q->suiv);
	}
	else
	{
		new = creer_monome(p->coef + q->coef, p->degree);
		new->suiv = somme(p->suiv, q->suiv);
	}
	return (new);
}

t_maillon	*get_poly_from_input(int nbr_monome)
{
	if (nbr_monome <= 0)
		return (NULL);

	int			deg, coeff;
	int			count = 0;
	t_maillon	*head;
	do 
	{
		printf("Enter the degree then the coefficient of monome %d :\n", count);
		scanf("%d %d", &deg, &coeff);
		if (count == 0)
			head = creer_monome(coeff, deg);
		else
		{
			head = ajoute_monome(head, coeff, deg);
			if (!head)
				return (liberer(head), perror(""), NULL);
		}
	} while (++count < nbr_monome);
	return (head);
}

int main(int argc, char *argv[])
{
	if (argc != 3)
	{
		printf("Invalid arg count\nUsage : ./a.out [nbr_monome_p1] [nbr_monome_p2]\n");
		return (1);
	}

	printf("Entrez maintenant les details du 1er Polynome :\n");
	t_maillon *p1 = get_poly_from_input(atoi(argv[1]));
	printf("\nNotre 1er polynome vaut : ");
	affiche_polynome(p1);
	printf("\n");
	
	printf("Entrez maintenant les details du 2eme Polynome :\n");
	t_maillon *p2 = get_poly_from_input(atoi(argv[2]));
	printf("\nNotre 2eme polynome vaut : ");
	affiche_polynome(p2);
	printf("\n");

	t_maillon *s = somme(p1, p2);
	printf("\nLa somme vaut : ");
	affiche_polynome(s);
	printf("\n");

	liberer(p1);
	liberer(p2);
	liberer(s);

	return (0);
}

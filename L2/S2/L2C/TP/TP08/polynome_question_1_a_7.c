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


int main(void)
{
	t_maillon *p = creer_monome(1, 2);	
	t_maillon *q = creer_monome(2, 1);
	t_maillon *r = creer_monome(3, 0);

	p->suiv = q;
	q->suiv = r;
	
	printf("p(2) = %f\n", evaluer_polynome(p, 2));
	affiche_polynome(p);
	printf("\n");

	p = ajoute_monome(p, 4, 2);
	// should print 5 * x^2 + 2 * x^1 + 3 * x^0 
	affiche_polynome(p);
	printf("\n");
	
	p = ajoute_monome(p, 5, 3);
	// should print 5 * x^3 + 5 * x^2 + 2 * x^1 + 3 * x^0
	affiche_polynome(p);
	printf("\n");

	p = ajoute_monome(p, 6, 1);
	// should print 5 * x^3 + 5 * x^2 + 8 * x^1 + 3 * x^0
	affiche_polynome(p);
	printf("\n");




	t_maillon *p2 = creer_monome(2, 2);
	t_maillon *q2 = creer_monome(2, 2);
	t_maillon *s = somme(p2, q2);
	// should print 4 * x^2
	affiche_polynome(s);


	liberer(p);
	liberer(p2);
	liberer(q2);
	liberer(s);
}

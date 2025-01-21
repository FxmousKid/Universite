#include <stdio.h>
#include <stdlib.h>

size_t	nbr_occ(int *tab, size_t size, int val)
{
	size_t	idx;
	size_t	count;

	if (!tab)
		return 0;
	count = 0;
	idx = 0;
	while (idx < size)
		count += tab[idx++] == val;
	return (count);
}

void	nbr_occ_op(int *tab, size_t size, int val, size_t *pnv)
{
	if (!tab || !pnv)
		return ;
	*pnv = nbr_occ(tab, size, val);
}

/* We are assuming that *pmin and *pmax have been initialized before being passed
 * to avoir problems */
void	min_max_op(int *tab, size_t size, int *pmin, int *pmax)
{
	size_t	idx;

	if (!tab || !pmin || !pmax)
		return ;
	*pmax = tab[0];
	*pmin = tab[0];
	idx = 1;
	while (idx < size) {
		if (tab[idx] < *pmin)
			*pmin = tab[idx];
		else if (tab[idx] > *pmax)
			*pmax = tab[idx];
		idx++;
	}
}

void	print_tab(int *tab, size_t size)
{
	size_t	idx;

	if (!tab)
		return ;
	idx = 0;
	while (idx < size) {
		printf("%d", tab[idx]);
		if (idx < size - 1)
			printf(", ");
		idx++;
	}
}


int main(void)
{
	int	tab[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
	size_t	size = sizeof(tab) / sizeof(*tab);
	size_t	nb_occ;
	int	min;
	int	max;

	
	printf("The array is: [");
	print_tab(tab, size);
	printf("]\n");
	nbr_occ_op(tab, size, 5, &nb_occ);
	printf("5 appears %zu times in the array\n", nb_occ);
	min_max_op(tab, size, &min, &max);
	printf("The minimum value in the array is %d and the maximum value is %d\n", min, max);
	return (EXIT_SUCCESS);
}

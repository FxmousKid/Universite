#include <stdio.h>
#include <string.h>
#include <stdbool.h>

#ifndef SUP
# define SUP 24
#endif

static void	pretty_print_arr(bool tab[], size_t size)
{
	size_t	idx = 0;

	printf("[");
	while (idx < size) {
		if (tab[idx])
			printf("%zu, ", idx);
		idx++;
	}
	printf("]\n");
}

static void	remove_mult(size_t n, bool tab[], size_t size)
{
	int	initial_n = n;

	n += initial_n;
	while (n < size) {
		tab[n] = false;
		n += initial_n;
	}
}

static void	eratosthene()
{
	size_t	idx = 2;
	bool	tab[SUP];

	memset(tab, true, SUP);
	while (idx < SUP) {
		remove_mult(idx, tab, SUP);
		idx++;
	}
	pretty_print_arr(tab, SUP);
}

int main(void)
{
	eratosthene();
	return (0);
}

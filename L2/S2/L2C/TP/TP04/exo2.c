#include <stdio.h>
#include <stdlib.h>

size_t	occ(int *tab, size_t size, int val)
{
	size_t	idx;

	idx = 0;
	while (idx < size) {
		if (tab[idx] == val)
			return (idx);
		idx++;
	}
	return (size);
}

int	*occ_ptr(int *tab, size_t size, int val)
{
	size_t	idx;

	idx = 0;
	while (idx < size) {
		if (tab[idx] == val)
			return (tab + idx); // &tab[idx] aurait egalement marcher
		idx++;
	}
	return (NULL);
}

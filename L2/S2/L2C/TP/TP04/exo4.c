#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>

void	print_tab_2(int *tab, size_t start, size_t end)
{
	printf("Array : [\n");
	while (start < end - 1) {
		printf("%p = %d\n", tab + start, tab[start]);
		start++;
	}
	printf("%p = %d]\n", tab + start, tab[start]);
}

void	print_tab(int *pstart, int *pend)
{
	uintptr_t	end;
	
	end = ((uintptr_t)pend - (uintptr_t)pstart) / sizeof(int);	
	print_tab_2(pstart, 0, end);
}

int main(void)
{
	int	tab[10] = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};

	print_tab_2(tab, 0, 10);
	printf("\n");
	print_tab(tab, tab + 10);
	return (EXIT_SUCCESS);
}

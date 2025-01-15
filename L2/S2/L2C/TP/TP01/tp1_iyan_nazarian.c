#include <stdio.h>
#include <stdbool.h>

# ifndef SYRACUSE
#  define SYRACUSE 3
# endif

int	sum_3rd_power_decr(int n)
{
	int	res = 0;

	while (n > 0) {
		res += (n * n * n);
		n--;
	}
	return (res);
}

size_t	fact(size_t n)
{
	if (n == 0)
		return (1);
	return n * fact(n - 1);
}

void	fact_list(size_t n)
{
	size_t	count = 0;

	if (n == 0)
		return ;
	while (count <= n) {
		printf("%zu! = %zu\n", count, fact(count));
		count++;
	}
}

void	listen_and_cal_avg_input(void)
{
	float	input;
	float	sum = 0;
	int		count = 0;

	do {
		printf("Entrez un entier : ");
		scanf("%f", &input);
		sum += input;
		count++;
	}
	while (input != 0);
	count--;
	float moyenne = sum / count;
	printf("La moyenne vaut : %.6f\n", moyenne);
}


void	syracuse(int n, bool disp_conj)
{
	int	tdv = 0;
	int	initial_n = n;

	if (n < 1)
		return ;
	while (n != 1) {
		if (n % 2 == 0)
			n /= 2;
		else
			n = 3 * n + 1;
		tdv++;
		if (disp_conj)
			printf("%d ", n);
	}
	if (disp_conj)
		printf("\n");
	printf("%d : %d\n", initial_n, tdv);
}

void	syracuse_list(size_t n)
{
	size_t	count = 1;

	while (count <= n) 
		syracuse(count++, false);
}


int main(void)
{
	size_t	input;
	int	res;

	printf("Please enter a positive number for ex1 : ");
	scanf("%zu", &input);
	res = sum_3rd_power_decr(input);
	printf("sum_3rd_power_decr(%zu) = %d\n\n", input, res);

	printf("Please enter a positive number for ex2 : ");
	scanf("%zu", &input);
	res = fact(input);
	printf("fact(%zu) = %d\n\n", input, res);

	printf("Please enter a positive number for ex3 : ");
	scanf("%zu", &input);
	printf("\n");
	fact_list(input);

	printf("\n");
	listen_and_cal_avg_input();

	printf("\n");
	syracuse(SYRACUSE, true);

	printf("\n");
	syracuse_list(SYRACUSE);

	return (0);
}

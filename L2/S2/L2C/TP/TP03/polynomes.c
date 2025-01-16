#include <stdio.h>
#include <stdlib.h>

#ifndef N
# define N 100
#endif

typedef struct s_polynome
{
	int	de; // degree, 0 <= de < N
	int	co[N]; // coeficients
}		t_polynome;

/* returns a^b, b >= 0, returns 1 for 0^0 */
int	my_pow(int a, size_t b)
{
	int	res = 1;

	if ((!a && !b) || !b)
		return (1);

	while (b--)
		res *= a;
	return (res);
}

int	eval(t_polynome p, int x)
{
	int	res = 0;
	int	idx = 0;

	while (idx <= p.de) {
		res += my_pow(x, idx) * p.co[idx];
		idx++;
	}
	return (res);
}

void	print_poly(t_polynome p)
{
	int	idx = p.de;

	while (idx > 1) {
		if (p.co[idx] > 0)
			printf("%dX^%d + ",p.co[idx], idx);
		idx--;
	}
	p.co[1] ? printf("%dX", p.co[1]): (void) idx;
	p.co[1] && p.co[0] ? printf(" + ") : (void) idx;
	p.co[0] ? printf("%d\n", p.co[0]) : printf("\n");
}

t_polynome	derive(t_polynome p)
{
	t_polynome	p2 = {0};

	p2.de = (p.de > 0) ? p.de - 1 : 0;
	for (int i = 0; i <= p2.de; i++)
		p2.co[i] = p.co[i + 1] * (i + 1); 

	return (p2);
}

t_polynome	sum_poly(t_polynome p1, t_polynome p2)
{
	t_polynome	sum = {0};

	// <==> max(p1.de, p2.de);
	sum.de = (p1.de > p2.de) ? p1.de : p2.de;
	for (int idx = 0; idx <= sum.de; idx++) 
		sum.co[idx] = p1.co[idx] + p2.co[idx];

	return (sum);
}

t_polynome	mul_poly(t_polynome p1, t_polynome p2)
{
	t_polynome	mul = {0};

	mul.de = p1.de + p2.de;
	// m_p1_idx : index du monome de p1 concerner.
	for (int m_p1_idx = 0; m_p1_idx <= p1.de; m_p1_idx++) {
		// m_p2_idx : indeux du monome de p2 concerner
		for (int m_p2_idx = 0; m_p2_idx <= p2.de; m_p2_idx++) {
			mul.co[m_p1_idx + m_p2_idx] += p1.co[m_p1_idx] * p2.co[m_p2_idx];
		}
	}
	return (mul);
}

int main(void)
{
	t_polynome	p = {3, {1, 4, 0, 3}};

	printf("p = ");
	print_poly(p);
	printf("p' = ");
	print_poly(derive(p));
	printf("p + p' = ");
	print_poly(sum_poly(p, derive(p)));
	printf("p x p' = ");
	print_poly(mul_poly(p, derive(p)));
	return (0);
}

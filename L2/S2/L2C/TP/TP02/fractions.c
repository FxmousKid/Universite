#include <stdio.h>
#include <assert.h>
#include <stdbool.h>

typedef struct s_fraction
{
	long int	num;
	long int	den;
}				t_fraction;

t_fraction	build(long int num, long int den)
{
	t_fraction	frac;

	assert(den != 0);
	frac.num = num;
	frac.den = den;
	return (frac);
}

bool	eq_fractions(t_fraction f, t_fraction g)
{
	return (f.num * g.den == f.den * g.num);
}

bool	is_int(t_fraction f)
{
	return (f.num % f.den == 0);
}

t_fraction	mul(t_fraction f, t_fraction g)
{
	return ((t_fraction) {f.num * g.num, f.den * g.den});
}

t_fraction sub(t_fraction f, t_fraction g)
{
	t_fraction frac;

	if (f.den != g.den) {
		frac.den = f.den * g.den;
		frac.num = f.num * g.den - g.num * f.den;
	}
	else {
		frac.den = f.den;
		frac.num = f.num - g.num;
	}
	return (frac);
}

t_fraction add(t_fraction f, t_fraction g)
{
	t_fraction frac;

	if (f.den != g.den) {
		frac.den = f.den * g.den;
		frac.num = f.num * g.den + g.num * f.den;
	}
	else {
		frac.den = f.den;
		frac.num = f.num + g.num;
	}
	return (frac);
}

static long int	pgcd(long int a, long int b)
{
	long int	x = a;
	long int	y = b;
	long int	r;
	
	while (y) {
		r = x % y;
		x = y;
		y = r;
	}
	return (x);
}

t_fraction reduce(t_fraction f)
{
	t_fraction	frac;
	int			pgcd_frac;

	pgcd_frac = pgcd(f.num, f.den);

	frac.den = f.den / pgcd_frac;
	frac.num = f.num / pgcd_frac;

	if (frac.den < 0) {
		frac.den *= -1;
		frac.num *= -1;
	}
	return (frac);
}

void test_functions(t_fraction *f)
{
	// Test eq_f
	printf("Testing eq_f:\n");
	printf("%ld/%ld == %ld/%ld? %d\n", f[0].num, f[0].den, f[1].num, f[1].den, eq_fractions(f[0], f[1]));

	// Test is_int
	printf("\nTesting is_int:\n");
	printf("%ld/%ld is int? %d\n", f[0].num, f[0].den, is_int(f[1]));
	printf("%ld/%ld is int? %d\n", f[1].num, f[1].den, is_int(f[1]));

	// Test mul
	printf("\nTesting mul:\n");
	t_fraction mul_result = mul(f[1], f[2]);
	printf("%ld/%ld * %ld/%ld = %ld/%ld\n", f[1].num, f[1].den, f[2].num, f[2].den, mul_result.num, mul_result.den);

	// Test sub
	printf("\nTesting sub:\n");
	t_fraction sub_result = sub(f[1], f[2]);
	printf("%ld/%ld - %ld/%ld = %ld/%ld\n", f[1].num, f[1].den, f[2].num, f[2].den, sub_result.num, sub_result.den);

	// Test add
	printf("\nTesting add:\n");
	t_fraction add_result = add(f[1], f[2]);
	printf("%ld/%ld + %ld/%ld = %ld/%ld\n", f[1].num, f[1].den, f[2].num, f[2].den, add_result.num, add_result.den);

	// Test reduce
	printf("\nTesting reduce:\n");
	t_fraction reduced = reduce(f[3]);
	printf("Reduced %ld/%ld to %ld/%ld\n", f[3].num, f[3].den, reduced.num, reduced.den);
}

int main(void)
{
	t_fraction ex_fractions[] = {
		build(1, 1),
		build(1, 2),
		build(2, 4),
		build(-9, 3),
		build(8, -20),
		build(-5, -1),
		build(1, -3)
	};

	test_functions(ex_fractions);
	return (0);
}

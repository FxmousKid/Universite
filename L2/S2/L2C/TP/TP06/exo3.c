#include <stdio.h>
#include <string.h>
#include <assert.h>

typedef struct s_mutation {
	size_t	indice;
	size_t	len;
}			t_mutation;


int	strcmp_n(const char *s1, const char *s2, int n)
{
	unsigned char	*str1;
	unsigned char	*str2;

	str1 = (unsigned char *)s1;
	str2 = (unsigned char *)s2;
	while (*str1 && *str2 && *str1 == *str2 && n > 1)
	{
		str1++;
		str2++;
		n--;
	}
	return (*str1 - *str2);
}

/* return the number of time sub occurs in s (even if overlapping) */
int	nboc(const char *s, const char *sub)
{
	assert (s && sub);

	int	count = 0;
	int	len_sub = strlen(sub);

	while (strlen(s) >= strlen(sub))
		count += strcmp_n(s++, sub, len_sub) == 0;


	return (count);
}

/* if len(s) != len(t) returns (t_mutation){0, 0} */
t_mutation	diff(const char *s, const char *t)
{
	assert(s && t);

	int	idx;

	if (strlen(s) != strlen(t))
		return ((t_mutation) {0, 0});

	t_mutation	mut = {0, 0};
	while (s[mut.indice] == t[mut.indice])
		mut.indice++;
	
	idx = mut.indice;
	while (s[idx] != t[idx])
	{
		mut.len++;
		idx++;
	}

	return (mut);
}

static inline void	copy_mutation(t_mutation *src, t_mutation *dest)
{
	dest->len = src->len;
	dest->indice = src->indice;
}


/* returns the first longest mutation found */
t_mutation	longest(const char *s, const char *t)
{
	assert (s && t);

	t_mutation	longest_mut;
	t_mutation	tmp;

	if (strlen(s) != strlen(t))
		return ((t_mutation) {0, 0});

	longest_mut = (t_mutation) {0, 0};
	while (s[0]) {
		tmp = diff(s, t);
		if (tmp.len > longest_mut.len)
			copy_mutation(&tmp, &longest_mut);
		s += tmp.len + tmp.indice;
		t += tmp.len + tmp.indice;
	}

	return (longest_mut);
}

int main(void)
{
	char *str = "aaabbaabb";
	char *sub = "aa";

	printf("nboc(\"%s\", \"%s\") = %d\n", str, sub, nboc(str, sub));
	
	t_mutation	mut = diff("aaaa", "acca");
	printf("diff(\"aaaa\", \"acca\") = {%zu, %zu}\n", mut.indice, mut.len);

	mut = longest("atcgatatt", "aaagccata");
	printf("longest(\"atcgatatt\", \"aaagccata\") = {%zu, %zu}\n", mut.indice, mut.len);
}

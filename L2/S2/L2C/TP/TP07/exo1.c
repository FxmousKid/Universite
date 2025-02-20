#include <stdio.h>
#include <stdlib.h>
#include <assert.h>

int occurences(char c, char *sep)
{
	while (*sep)
		if (c == *sep++)
			return (1);
	return (0);
}

int	nbr_words(char *str)
{
	int		wordcount;
	int		f_change;
	char	*sep;

	if (!str)
		return (0);

	wordcount = 0;
	f_change = 1;
	sep = " ";
	while (*str)
	{
		wordcount += (f_change && !occurences(*str, sep));
		f_change = (occurences(*str++, sep));
	}
	return (wordcount);
}


int	word_len(const char *w)
{
	assert(w);
	int	count = 0;

	while (w[count++] != ' ');
	return (--count);
}

/* pocket (not accurate because we don't pad with '\0')
 * implementation of strncpy */
char	*my_strncpy(char *dst, const char *src, size_t dsize)
{
	size_t	idx;

	if (!dst || !src || !dsize)
		return (dst);

	idx = 0;
	while (src[idx] && idx < dsize - 1)
		*dst++ = src[idx++];
	return (dst);
}

/* returns NULL if a word hasn't been found */
char	*extract_word(const char *w, int *pl)
{
	assert (w && pl);

	size_t	w_len;
	char	*ret_word;

	w_len = word_len(w);
	if (!w_len)
		return (NULL);
	ret_word = (char *) malloc(w_len * sizeof(char) + 1);
	if (!ret_word)
		return (NULL);
	my_strncpy(ret_word, w, w_len + 1);
	*pl = w_len;
	return (ret_word);
}

char	*next_word(char *w)
{
	while (*w && *w != ' ')
		w++;
	if (!*w || *w == ' ')
		return (NULL);
	return (w);
}

int main(void)
{
	char *str = " a aa ba a bbbb ";
	printf("Number of words: %d\n", nbr_words(str));
	
	printf("word_len(%s) = %d\n", str + 3, word_len(str + 3));

	int len;
	char *word = extract_word(str + 3, &len);
	printf("extract_word(%s) = %s\n", str + 3, word);
	free(word);

	char *w = str;
	while ((w = next_word(w)))
	{
		int len;
		char *word = extract_word(w, &len);
		printf("extract_word(%s) = %s\n", w, word);
		free(word);
	}
	return (0);
}

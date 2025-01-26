#include <stdio.h>
#include <stdlib.h>
#include <assert.h>
#include <stdbool.h>
#include <string.h>


// Message pour les correcteurs :
// Regardez dans la libc les prototypes des fonctions standards
// dans lesquelles on passe un dynamic array ; size represente la
// valeur passer a malloc. Pourquoi on ne suit pas cette convention ?
//
// capacity devrait s'appeler size
// size devrait s'appeler count ou meme total.
// Merci.

// Dans le point 3 du debut de l'exo 2, il sort d'ou td.size ? a.size a la place

typedef struct s_array
{
	int		*content;
	size_t	capacity;
	size_t	size;
}			t_array;


t_array		*array_init(size_t capacity)
{
	t_array	*arr;

	arr = (t_array *) calloc(1, sizeof(t_array));
	if (!arr) {
		perror("");
		return (NULL);
	}

	arr->content = (int *) calloc(capacity, sizeof(int));
	if (!arr->content) {
		perror("");
		free(arr);
		return (NULL);
	}
	arr->capacity = capacity;
	arr->size = 0;
	return (arr);
}

void	array_destroy(t_array *pa)
{
	// eviter que arr-> segfault	
	if (!pa)
		return ;
	free(pa->content);
	free(pa);
}

int	array_get(t_array *pa, size_t index)
{
	assert(index < pa->size && pa);
	return (pa->content[index]);
}

void	array_set(t_array *pa, size_t index, int value)
{
	assert (index < pa->size && pa);
	pa->content[index] = value;
}

bool	array_append(t_array *pa, int value)
{
	assert(pa->size <= pa->capacity);
	if (pa->size == pa->capacity)
		return (false);
	pa->content[pa->size] = value;
	pa->size++;
	return (true);
}

void	array_print(t_array *pa)
{
	size_t	idx;

	printf("pa->content : [");
	idx = 0;
	while (pa->size && idx < pa->size - 1)
	{
		printf("%d, ", pa->content[idx]);
		idx++;
	}
	printf("%d]\n", pa->content[idx]);
}

int	*array_seatch(t_array *pa, int value)
{
	size_t	idx;

	idx = 0;
	while (idx < pa->size)
	{
		if (pa->content[idx] == value)
			return (pa->content + idx);
		idx++;
	}
	return (NULL);
}

t_array *array_init_from(int *data, size_t length, size_t capacity)
{
	t_array	*arr;
	size_t	idx;

	assert(capacity >= length && data);
	arr = array_init(capacity);
	if (!arr)
		return (NULL);
	idx = 0;
	while (idx < length)
	{
		if (!array_append(arr, data[idx]))
		{
			array_destroy(arr);
			return (NULL);
		}
		idx++;
	}
	return (arr);
}

void	array_remove(t_array *pa, size_t index)
{
	int		offset;

	assert(pa && index < pa->size);

	// it means we have to remove the 1st elem
	pa->size--;
	if (pa->size == 0)
		return ;
	offset = pa->size - index;
	memmove(pa->content + index, pa->content + index + 1, offset * sizeof(int));
}

/* returns false if needed to realloc and it failed, i.e. pa->content = NULL*/
bool	array_insert(t_array *pa, size_t index, int value)
{
	int	offset;

	assert(pa && index <= pa->size);
	if (pa->capacity == pa->size)
		pa->content = realloc(pa->content, 2 * pa->capacity);
	if (!pa->content)
		return (false);
	if (pa->capacity == pa->size) {
		bzero(pa->content + 1, pa->capacity);
		pa->capacity *= 2;
		if (index == pa->size)
			return (array_append(pa, value), false);
	}
	offset = pa->size - index;
	memmove(pa->content + index + 1, pa->content + index, offset * sizeof(int));
	array_set(pa, index, value);
	pa->size++;
	return (true);
}


int main(void)
{
	t_array	*arr;
	t_array *arr2;

	arr = array_init(10);
	if (!arr)
		return (1);
	array_append(arr, 44);
	array_append(arr, 43);
	array_append(arr, 42);
	array_append(arr, 41);
	array_print(arr);

	arr2 = array_init_from(arr->content, arr->size, arr->capacity);
	if (!arr2)
	{
		array_destroy(arr);
		return (1);
	}
	array_print(arr2);

	array_remove(arr2, 1);
	array_print(arr2);
	
	if (array_insert(arr2, 1, 43))
		array_print(arr2);

	array_destroy(arr);
	array_destroy(arr2);
	return (0);
}

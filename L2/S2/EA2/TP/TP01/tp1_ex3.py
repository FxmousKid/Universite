#!/usr/bin/env python3

#
# A REMPLIR
#
def crible_eratosthene(n):
# calcule la table de booléens où la i-ème position est True
# si et seulement si i est un nombre premier.
    def remove_mult(tab: list[bool], n: int) -> None :
        og_n: int = n
        len_tab: int = len(tab)
        while n < len_tab :
            tab[n] = False
            n += og_n
    
    tab: list[bool] = [True] * (n + 1)
    tab[0] = False
    tab[1] = False
    i: int = 2
    while i < n :
        if tab[i] :
            remove_mult(tab, i)
        i += 1
    return tab

def test_crible(n):
    c = crible_eratosthene(n)
    for i in range(len(c)):
        if c[i]:
           print(i, end= ' ')
    print()

# AJOUTER D'AUTRES TESTS
#  [valeur_x, resultat_attendu]
def testDataSomme() :
    """retourne un jeu de tests"""
    return [[0, 0], [3, 4], [24, 144], [-3, 0]]

#
# A REMPLIR
#
def somme_impairs(x) :
    return sum([i for i in range(1, x + 1, 2)])

def test_somme() :
    test: list[list[int]] = testDataSomme()

    print("Test de la fonction somme_impairs() :\n")
    for test_pair in test :
        print(f"  Test {test.index(test_pair) + 1}/{len(test)} : ", end = "")
        if (somme_impairs(test_pair[0]) != test_pair[1]) :
            print("ECHEC")
        else :
            print("ok")
    return True




#
# NE PAS MODIFIER
#
def testOp(op, data) :
	print('\n\n* Test function %s:' % op.__name__)
	score = 0
	ldata = len(data)
	for i, dt in enumerate(data) :
		print('** test %d/%d : ' % (i + 1, ldata), end='')
		x = dt[0]
		refr = dt[1]
		r = op(x)
		if r == refr :
			score+=1
			print('ok')
		else :
			print('ECHEC')
			print('    entree  : %s' % x)
			print('    calcule : %s' % r)
			print('    attendu : %s' % refr)
	print('** Score %d/%d' % (score, ldata))


if __name__ == '__main__':
        test_crible(50)
        testOp(somme_impairs, testDataSomme())

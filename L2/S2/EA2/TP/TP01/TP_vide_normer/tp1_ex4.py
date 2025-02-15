#!/usr/bin/env python3


#
# La valeur du tableau de chiffres 
#
def valeur(tab: list[int]) -> int:
    nb = tab[:]
    nb.reverse()
    return int('0' + ''.join([str(c) for c in nb]))

#
# Le tableau des chiffres (poids faible en premier)
#
def tableau(entier : int) -> list:
    return [int(c) for c in str(entier)[::-1]]
  
#
# A REMPLIR
#
# L'addition de deux tableaux de chiffres decimaux de taille egale
#
def addition(nb1: list[int], nb2: list[int]) -> tuple[list[int], int]:
    "addition de deux entiers representes pas des tableaux de chiffres"
    res: list[int] = []
    retenue: int = 0
    op: int = 0
    for (chiffre1, chiffre2) in zip(nb1, nb2) :
        tmp: int = chiffre1 + chiffre2 + retenue
        op += 0 # A REMPLIR
        retenue = tmp // 10 
        res.append(tmp % 10)
        op += 0 # A REMPLIR
    return (res + [retenue] if retenue > 0 else res), op

#
# A REMPLIR
#
# L'addition de deux tableaux de chiffres decimaux de taille differente
#
def additionV(nb1: list[int], nb2: list[int]) -> tuple[list[int], int]:
    # A REMPLIR
    return addition(nb1, nb2)
  
#
# A COMPLETER
#
# La multiplication de deux tableaux de chiffres decimaux: methode 1
#
def multiplication1(nb1: list[int], nb2: list[int]) -> tuple[list[int], int]:
    "multiplication de nb1, nb2 tableaux de chiffres par additions"
    res: list[int] = nb1[:]  # copie du premier nombre
    vnb2: int = valeur(nb2)
    op: int = 0
    for _ in range(1, vnb2) :
        tmp: int
        res, tmp = additionV(res, nb1)
        op += 0 # A REMPLIR
    return res, op

def multiplication_par_un_chiffre(nb1: list[int], chiffre2: int) -> tuple[list[int], int]:
    "multiplication de nb1 par chiffre2"
    res: list[int] = []
    retenue: int = 0
    op: int = 0
    for chiffre1 in nb1 :
        tmp: int = chiffre1 * chiffre2 + retenue
        op += 0 # A REMPLIR
        retenue = tmp // 10
        res.append(tmp % 10)
        op += 0 # A REMPLIR
    return (res + [retenue]), op

#
# A COMPLETER
#
# La multiplication de deux tableaux de chiffres decimaux: methode 2
#
def multiplication2(nb1: list[int], nb2: list[int]) -> tuple[list[int], int]:
    "multiplication de nb1, nb2 tableaux de chiffres par algo pose"
    res: list[int] = []
    op: int = 0
    for (i, chiffre2) in enumerate(nb2) :
        tmp: list[int]
        opm: int
        tmp, opm = multiplication_par_un_chiffre(nb1, chiffre2)
        res: list[int]
        opa: int
        res, opa = additionV(res, [0] * i + tmp)
        # A COMPLETER
        op += 0 # A REMPLIR
    return res, op

#
# AJOUTER D'AUTRES TESTS
#  [parametres, [resultat_attendu, nb ops]]

def testDataAddEq() :
  return [ [ [[0, 1], [1, 1]], [[1, 2], 8] ],
	   [ [[9, 9], [1, 1]], [[0, 1, 1], 8] ],
	   [ [[8, 7, 2, 6], [2, 2, 7, 3]], [[0, 0, 0, 0, 1], 16] ]
	 ]

def testDataMul1() :
  return [ [ [[0, 1], [0, 1]], [[0, 0, 1], 72] ],
	   [ [[9, 9], [1, 1]], [[9, 8, 0, 1], 107] ],
	   [ [[8, 7, 2, 6], [2, 2, 7, 3]], [[6, 1, 7, 6, 6, 3, 3, 2], 98887] ]
	 ]

def testDataMul2() :
  return [ [ [[0, 1], [0, 1]], [[0, 0, 1, 0], 33] ],
	   [ [[9, 9], [1, 1]], [[9, 8, 0, 1], 33] ],
	   [ [[8, 7, 2, 6], [2, 2, 7, 3]], [[6, 1, 7, 6, 6, 3, 3, 2], 160] ]
	 ]


#
# NE PAS MODIFIER
#
def testOp(op, data) :
  print('\n\n* Test function %s:' % op.__name__)
  score = 0
  ldata = len(data)
  for i, dt in enumerate(data) :
    print('** test %d/%d : ' % (i + 1, ldata))
    x = dt[0][0]
    y = dt[0][1]
    refr = 0
    refc = 0
    if (len(dt[1]) > 1) :
      refr = dt[1][0]
      refc = dt[1][1]
    else :
      refr = dt[1]
    res = op(x, y)
    if (len(res) > 1) :
      r = res[0]
      c = res[1]
    else :
      r = res
      c = 0
    if (r == refr or valeur(r) == valeur(refr)) and c >= refc :
      score+=1
      print('ok (%s, %s ops)' % (r, c))
    else :
      print('ÉCHEC')
      print('    entrées : %s, %s' % (x, y))
      print('    résultat obtenu : %s' % r)
      print('    attendu : %s' % refr)
      if refc > 0 :
        print(' en minimum %d opérations (vs %d)' % (refc, c))
      else :
        print('')

  print('** Score %d/%d' % (score, ldata))


if __name__ == '__main__':
  testOp(addition, testDataAddEq())
  testOp(multiplication1, testDataMul1())
  testOp(multiplication2, testDataMul2())



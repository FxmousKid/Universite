# **************************************************************************** #
#                                                                              #
#                                                         :::      ::::::::    #
#    exercice5.py                                       :+:      :+:    :+:    #
#                                                     +:+ +:+         +:+      #
#    By: inazaria <inazaria@student.42.fr>          +#+  +:+       +#+         #
#                                                 +#+#+#+#+#+   +#+            #
#    Created: 2024/09/19 15:57:54 by inazaria          #+#    #+#              #
#    Updated: 2024/09/19 21:56:07 by inazaria         ###   ########.fr        #
#                                                                              #
# **************************************************************************** #

def compte4(tab: list[int], i: int) -> int :
    return (tab[i] + tab[i + 1] + tab[i + 2] + tab[i + 3]);

def Sum100(tab: list[int]) -> int :
    """Returns 4 consecutive indices that sum to 100"""
    for i in range(len(tab) - 2) :
        if compte4(tab, i) == 100 :
            return i
    return -1

def OptiSum100(tab: list[int]) -> int :
    """Returns the 1st index of the 1st 4 consecutive numbers that sum to 100
    But now optimized !"""
    sum: int = compte4(tab, 0);
    for i in range(1, len(tab) - 2) :
        if sum == 100 :
            return i - 1
        sum -= tab[i - 1]
        sum += tab[i + 3]
    return -1
    

def main() -> None :
    tab = [2, 2, 2, 2, 25, 25, 25, 25]
    i = Sum100(tab)
    j = OptiSum100(tab)
    print("Sum 100      : tab = ", tab ,"i = ", i)
    print("Sum 100 Opti : tab = ", tab ,"i = ", j)



# Dans le pire des cas, on a O(4(n - 3)) : [1,1,1,1,1, ... ,1 ,1]
# et dans le meuilleur cas Omega(4) : [25,25,25,25, ...]

main()

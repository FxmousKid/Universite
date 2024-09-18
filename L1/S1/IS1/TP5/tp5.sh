mkdir TP5
cd TP5

echo "#!/bin/bash" >toto.sh
cat << EOF >> toto.sh
DIRNAME=\$(dirname "\$0")
if [ "\${DIRNAME::1}" = "/" ] || [ "\${DIRNAME::1}" = "~" ];
then
	echo "Bonjour, \$USER ! Tu m'as appelé en utilisant un chemin absolu."
  echo "Si tu en es à la question 2, c'est bon, tu peux passer à la suite ! Sinon, essaie encore."
	exit 1
fi

BASEPWD=\$(basename "\$(pwd)")

case \$BASEPWD in
E) Q="a";;
B) Q="b";;
F) Q="c";;
G) Q="d";;
C) Q="e";;
A) Q="f";;
H) Q="g";;
*) Q="0";;
esac
if [[ "\$Q" == "0" ]]; then
	echo "Tu ne m'as pas appelé du bon endroit ou de la bonne façon ! Essaie encore."
	exit 1
fi

echo "Ce script est appelé depuis le répertoire \$BASEPWD de l'arborescence."

echo "Si tu en es à la question 3.\$Q, c'est bon, tu peux passer à la suite ! Sinon, essaie encore."
EOF

chmod a=rx toto.sh

mkdir Chemins_relatifs
cd Chemins_relatifs
mkdir -p A/B/E A/B/F A/B/G A/C A/D/H A/D/I
cd ..
mv toto.sh Chemins_relatifs/A/B/E

echo "echo \"Ce n'est pas le bon fichier !\"">toto.sh
chmod a=rx toto.sh
cp toto.sh Chemins_relatifs/A
cp toto.sh Chemins_relatifs/A/B
cp toto.sh Chemins_relatifs/A/C
cp toto.sh Chemins_relatifs/A/D
cp toto.sh Chemins_relatifs/A/D/H
cp toto.sh Chemins_relatifs/A/D/I
cp toto.sh Chemins_relatifs/A/B/F
cp toto.sh Chemins_relatifs/A/B/G
mv toto.sh Chemins_relatifs
cd ..


mkdir -p TP5/Jokers
cd TP5/Jokers
mkdir Corbeille Ronsard Boileau

echo Mignonne, allons voir si la rose > esDrhn
echo Qui ce matin avoit desclose > iv3dHp
echo Sa robe de pourpre au Soleil, > jacf
echo A point perdu ceste vesprée > urgwe6
echo Les plis de sa robe pourprée, > vawGl
echo Et son teint au vostre pareil. > zuk4

echo "Hâtez-vous lentement, et sans perdre courage," > bFte
echo "Vingt fois sur le métier remettez votre ouvrage," > r4stTi
echo "Polissez-le sans cesse, et le repolissez," > tk6E
echo "Ajoutez quelquefois, et souvent effacez." > v5jh

RATE="e1xv4 aB25s u7k3f p6u1Bi vwjEqk3w mjkwdhw"
PERDU="bwus7X ud53 fr3H2 tsdkj4F glaskda pA3sjge"
RESTE="mnja jktf taki oFte i4jhg arjhe gasUo"

for fic in $RATE
do
  echo "Non, vous n'auriez pas dû garder celui-ci" > $fic
done

for fic in $PERDU
do
  echo "Non, celui-la ne convient pas" > $fic
done

for fic in $RESTE
do
  echo "fichier inutile" > $fic
done

cd ..

mkdir -p Arthur/A

touch Arthur/A/titi
touch Arthur/A/toto
touch Arthur/A/tutu

cp -r Arthur/A/ Arthur/B
cp -r Arthur/A/ Arthur/C
cp -r Arthur Bohort
mkdir Caradoc
cp -r Arthur Caradoc/A
cp -r Arthur Caradoc/B
cp -r Arthur/A Caradoc/C


mkdir -p Vide/.Cachee
cp -r Arthur Bohort Caradoc Vide/.Cachee
touch Vide/.coucou
touch Vide/.Cachee/Arthur/.coucou
touch Vide/.Cachee/Arthur/A/.coucou
touch Vide/.Cachee/Caradoc/B/.coucou
mv Vide/.Cachee/Caradoc Vide/.Cachee/.Caradoc
mv Vide/.Cachee/Bohort/C Vide/.Cachee/Bohort/.C

rm -rf Arthur Bohort

cp -r Caradoc Protegee

cp -r Vide/.Cachee Protegee/A/C
rm -rf Protegee/A/C/.Cachee/C
rm -rf Protegee/A/C/.Cachee/.C
rm -rf Protegee/A/C/.Cachee/B/.C
rm -rf Protegee/A/C/.Cachee/B/*

cd Protegee

mv A Amonbofis
mv B Batdaf
mv C Cloridric

chmod 700 Amonbofis Batdaf
chmod 400 Amonbofis/C/.Cachee
chmod 200 Batdaf/B/titi
chmod 600 Batdaf/B
chmod 500 Batdaf/C
chmod 600 Batdaf
chmod 500 Cloridric
chmod 500 .

cd ..

mv Caradoc Multiliens
cd Multiliens
rm -rf */C
find . -name 't?t?' -delete

touch C/titi ; ln C/titi A/A/toto ; ln C/titi B/B/titi
touch A/B/titi ; ln A/B/titi A/B/tutu; ln A/B/titi C/tata
touch A/B/toto
touch B/toto ; ln B/toto B/A/toto
touch B/A/tutu

mv A Alcazar
mv B BenKalishEzab
mv C Castafiore

cd ..

echo "Je m'en allais, les poings dans mes poches crevées;
Mon paletot aussi devenait idéal :
J'allais sous le ciel, Muse ! et j'étais ton féal;" > poeme_rimbaud

echo "Un beau matin de juillet, le réveil a sonné dès le lever du soleil
Et j'ai dit à ma poupée : \"Faut te s'couer!
C'est aujourd'hui qu'il pa-a-sse!\"
On arrive sur le boul'vard sans retard
Pour voir défiler le roi d'Zanzibar
Mais sur-le-champ, on est r'foulés par les agents.
Alors j'ai dit : " > chanson_vian

mkdir Bazar Tri

cd Bazar

touch a@B4 b7%c c#R5 a2+3 b%T1 c8-@ b6!# c1+@ a5^% a1b2 b3c4 c5d6 a7e8 b9f0 c1g2 a3h4 b5i6 c7j8 a9k0 a#2T b9@C c4!L a7%B b#3K c8!G a6@P b5%S c2!R a9?Q a3bc9 c6hy2 bq4w5 av2bg b7n1f cb6j8 ax1v3 bg5c7 c9de2 ac4i6 a1@bcd b2c@3a c#4ab5 a6bc#d b7cde% c!8abf a9bc-1 b0cd^2 c@1abe a2bc3: aB4c2E bD9j8A cN5u7K aM3b1Z bX7n2S cY9r8D aH6j4E  cR8s3T aU7w5V

ln bD9j8A bF2m1C 
ln bD9j8A a_G9

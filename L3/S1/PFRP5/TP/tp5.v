Require Import List Lia.
Import ListNotations.


(* EXERCICE 1 *)

Inductive btree : Type :=
  | Leaf: btree
  | Node: btree -> nat -> btree -> btree.

Print btree_ind.

Fixpoint mirror (a: btree) : btree :=
  match a with
  | Node l x r => Node (mirror l) x (mirror r)
  | Leaf => a
  end.

Lemma mirror_idem:
  forall (a: btree), mirror (mirror a) = a.
Proof.
  intros. induction a. simpl. reflexivity. simpl.
  rewrite IHa1. rewrite IHa2. reflexivity.
Qed.

Fixpoint tmap (f: nat -> nat) (a: btree) : btree := 
  match a with
  | Leaf => Leaf
  | Node l x r => Node (tmap f l) (f x) (tmap f r)
  end.

Lemma tmap_assoc (f g: nat -> nat) (a: btree) :
  tmap f (tmap g a) = tmap (fun x => f (g x)) a.
Proof.
  induction a. simpl. reflexivity. simpl.
  rewrite IHa1. rewrite IHa2. reflexivity.
Qed.

(* Question 6 *)

Fixpoint btree_to_list (a: btree) : list nat :=
  match a with
  | Leaf => []
  | Node l x r => (btree_to_list l) ++ x :: (btree_to_list r)
  end.

(* Question 7 *)
Lemma btree_to_list_recip (a: btree) (f: nat -> nat) :
  map f (btree_to_list a) = btree_to_list (tmap f a).
Proof.
  induction a. simpl. reflexivity. simpl. rewrite map_app.
  simpl. rewrite IHa1. rewrite IHa2. reflexivity.
Qed.

(* Question 8 *)
Fixpoint nb_labels (a: btree) : nat :=
  match a with
  | Leaf => 0
  | Node l x r => 1 + nb_labels l + nb_labels r
  end.

Print max.
Check max.

(* Question 9 *)
Fixpoint height (a: btree) :=
  match a with 
  | Leaf => 0
  | Node l x r => max (height l) (height r) + 1
  end.

(* Question 10 *)
Lemma height_lte_nb_labels (a: btree) :
  height a <= nb_labels a.
Proof.
  induction a.
  - simpl. lia.
  - simpl. lia.
Qed.

(* Question 11 *)
Fixpoint btree_in (x: nat) (t: btree) : Prop :=
  match t with
  | Leaf => False
  | Node l x' r => x'=x \/ btree_in x l \/ btree_in x r
  end. 

Lemma btree_in_proof (x: nat) (t: btree) :
  btree_in x t = In x (btree_to_list t).
Proof.
  induction t.
  - simpl. reflexivity.
  - 





















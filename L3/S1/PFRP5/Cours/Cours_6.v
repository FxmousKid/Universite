Require Import Arith Lia Bool List.
Import ListNotations.

Fixpoint fib n := 
  match n with
  | 0 => 1
  | 1 => 2
  | S ((S m) as p) => fib m + fib p
  end.

Compute fib 8.

Lemma fib_croissant n :
  fib n <= fib (S n).
Proof.
  induction n.
  - simpl. lia.
  - simpl in *. lia. (* change (fib (S (S n))) with (fib n + fib (S n)). *)
Qed.

Lemma fib_le_pow2_double n : 
  fib n <= 2^n /\ fib (S n) <= 2^(S n).
Proof.
  induction n.
  - simpl. lia.
  - split.
    + easy.
    + change (fib (S (S n))) with (fib n + fib (S n)).
      simpl Nat.pow in *. lia.
Qed.


Lemma fib_le_pow2 n : 
  fib n <= 2^n.
Proof.
  apply fib_le_pow2_double.
Qed.



Lemma fib_le_pow2' n : 
  fib n <= 2^n.
Proof.
  induction n using lt_wf_ind.
  destruct n.
  - simpl. lia.
  - destruct n.
    + simpl. lia.
    + change (fib (S (S n))) with (fib n + fib (S n)).
      assert (H1 := H n).
      assert (H2 := H (S n)).
      simpl Nat.pow in *.
      lia.
Qed.


Fixpoint split {A} (l: list A) : list A * list A :=
  match l with
  | [] => ([], [])
  | [a] => ([a], [])
  | a::b::l' => let '(l1, l2) := split l' in (a::l1, b::l2)
  end.



Fixpoint split' {A} (l: list A) : list A * list A :=
  match l with
  | [] => ([], [])
  | a::l' => let '(l1, l2) := split' l' in (a::l2, l1)
  end.


Lemma split_equiv {A} (l: list A) :
  split l = split l /\ forall a, split (a::l) = split' (a::l).
Proof.
  induction l.
  - simpl. easy.
  - split.
    + easy.
    + intro b. simpl. destruct IHl as (->,_).
      destruct (split' l) as (l1, l2). easy.
































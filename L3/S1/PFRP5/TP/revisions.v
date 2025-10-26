Require Import Bool List Arith. 
Import ListNotations.

Lemma Q1_1

 (A: Prop) :
  A -> A.
Proof.
  intros H.
  exact H. (* easy, exact, fonctionne aussi *)
Qed.


Lemma Q1_2 (A B C: Prop) :
  (A->B) -> (B->C) -> A -> C.
Proof.
  intros h1 h2 a.
  apply h2, h1, a.
Qed.


Lemma Q1_3 (A B: Prop) :
  (A /\ B) -> (B /\ A).
Proof.
  intros [h1 h2].
  split.
  - apply h2.
  - apply h1.
Qed.

Lemma Q1_4 (A B: Prop) :
  (A \/ B) -> (B \/ A).
Proof.
  intros H.
  destruct H as [hA | hB].
  - right. apply hA.
  - left. apply hB.
Qed.


Lemma Q1_5 (A B C: Prop) :
  (A /\ B) /\ C <-> A /\ (B /\ C).
Proof.
  split.
  - intros H. destruct H as [[hA hB] hC]. split.
    + apply hA.
    + split. apply hB. apply hC.
  - intros H. destruct H as [hA [hB hC]]. split.
    + split. apply hA. apply hB.
    + apply hC.
Qed.

Lemma Q1_6 (A B C: Prop) :
  (A \/ B) \/ C <-> A \/ (B \/ C).
Proof.
  split.
  - intros H. destruct H as [[hA | hB] | hC].
    left. apply hA.
    right. left. apply hB.
    right. right. apply hC.
  - intros H. destruct H as [hA | [hB | hC]].
    left. left. apply hA.
    left. right. apply hB.
    right. apply hC.
Qed.

Fixpoint length {A} (l: list A) : nat :=
  match l with
  | [] => 0
  | x :: xs => (S (length xs))
  end.

Lemma length_rev {A} (l: list A) :
  length l = length (rev l).
Proof.
  induction l as [| x l' IH].
  - simpl. reflexivity.
  - simpl. rewrite app_length.
 




    
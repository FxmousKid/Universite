open Dpll_solver.Dpll

let exemple_3_12 = [[1;2;-3];[2;3];[-1;-2;3];[-1;-3];[1;-2]]
let exemple_7_2 = [[1;-1;-3];[-2;3];[-2]]
let exemple_7_4 = [[1;2;3];[-1;2;3];[3];[1;-2;-3];[-1;-2;-3];[-3]]
let exemple_7_8 = [[1;-2;3];[1;-3];[2;3];[1;-2]]
let systeme = [[-1;2];[1;-2];[1;-3];[1;2;3];[-1;-2]]

let coloriage = [
  [1;2;3];[4;5;6];[7;8;9];[10;11;12];[13;14;15];[16;17;18];
  [19;20;21];[-1;-2];[-1;-3];[-2;-3];[-4;-5];[-4;-6];[-5;-6];
  [-7;-8];[-7;-9];[-8;-9];[-10;-11];[-10;-12];[-11;-12];[-13;-14];
  [-13;-15];[-14;-15];[-16;-17];[-16;-18];[-17;-18];[-19;-20];
  [-19;-21];[-20;-21];[-1;-4];[-2;-5];[-3;-6];[-1;-7];[-2;-8];
  [-3;-9];[-4;-7];[-5;-8];[-6;-9];[-4;-10];[-5;-11];[-6;-12];
  [-7;-10];[-8;-11];[-9;-12];[-7;-13];[-8;-14];[-9;-15];[-7;-16];
  [-8;-17];[-9;-18];[-10;-13];[-11;-14];[-12;-15];[-13;-16];
  [-14;-17];[-15;-18]]

let easy_sat = [[1]]
let easy_unsat = [[1];[-1]]
let unitaires_multiples = [[1];[2];[3];[1;2;3]]
let litteraux_purs = [[1;2];[1;3];[2;3]]
let unsat_classique = [[1;2];[-1;2];[1;-2];[-1;-2]]
let complexe_sat = [[1;2;3];[-1;2];[-2;3];[1;-3];[4;5];[-4;5];[3;-5]]
let mini_sudoku = [[1;2];[3;4];[5;6];[7;8];[-1;-2];[-3;-4];[-5;-6];[-7;-8];[-1;-3];
                   [-2;-4];[-5;-7];[-6;-8];[-1;-5];[-2;-6];[-3;-7];[-4;-8]]

let () = print_string "Test 1:\n"
let () = print_modele (solveur_split (cnf_of_int_list_list systeme))

let () = print_string "Test 2:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list systeme))

let () = print_string "Test 3:\n"
let () = print_modele (solveur_split (cnf_of_int_list_list coloriage))

let () = print_string "\nTest 4 easy_sat:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list easy_sat))

let () = print_string "\nTest 5 easy_unsat:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list easy_unsat))

let () = print_string "\nTest 6 coloriage:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list coloriage))

let () = print_string "\nTest 7 unitaires_multiples:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list unitaires_multiples))

let () = print_string "\nTest 8 litteraux_purs:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list litteraux_purs))

let () = print_string "\nTest 9 unsat_classique:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list unsat_classique))

let () = print_string "\nTest 10 complexe_sat:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list complexe_sat))

let () = print_string "\nTest 11 mini_sudoku:\n"
let () = print_modele (solveur_dpll (cnf_of_int_list_list mini_sudoku))
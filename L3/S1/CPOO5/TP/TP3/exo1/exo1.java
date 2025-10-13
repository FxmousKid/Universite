package exo1;
class A {}
class B {}
interface I {}
interface J {}


class C extends I {} // Faux, classe qui extend une interface..
interface K extends B {} // Faux, une superinterface ne peut etre que une interface
class C implements J {} // Vrai, classe qui implemente une interface
//interface K implements B {} // Faux, une interface ne peux pas *implementer* une classe
class C extends A implements I {} // Vrai, une clase qui extend une classe qui implemente une interface
interface K extends I, J {} // Vrai, une interface qui extends 2 interfaces
//class C extends A, B {} // Faux, une classe qui extends 2 classes
class C implements I, J {} // Vrai, java permet plus qu'une interface implementer par classe
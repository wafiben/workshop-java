package com.example.demo.solid;

public class DependecyInversion {
}


class X {

    private Y y;


    public X() {
        this.y = new Y();
    }

    private void methodA() {
        this.y.methodB();
    }

}

class Y {
    public Y() {

    }

    public void methodB() {
        System.out.println("opa");
    }
}



//dependency "injenjection";

//dependecy inversion superior dependecy injection

//l'inversion de dependance se fait par une abstraction une interface


//X==>Y
//
//X ===>interface<===y

interface Inversion {
    void methodB();
}

class X {

    private Inversion inversionInterface;


    public X() {

    }

    private void methodA() {
        this.inversionInterface.methodB();
    }

}

class Y  implements Inversion{
    public Y() {

    }

    public void methodB() {
        System.out.println("opa");
    }
}




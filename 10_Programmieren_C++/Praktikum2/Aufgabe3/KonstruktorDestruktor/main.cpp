#include <iostream>

using namespace std;

class X {
public:

    X() {
        mXObjNr = ++mXObjCounter;
        cout << "X::X() Objekt-Nr. = " << mXObjNr << "\n";
    }

    ~X() {
        cout << "X::~X() Objekt-Nr. = " << mXObjNr << "\n";
    }

private:
protected:
    static int mXObjCounter;
    int mXObjNr;

};

class Y : public X {
public:

    Y() {
        cout << "Y::Y() Objekt-Nr. = " << mXObjNr << "\n";
    }

    ~Y() {
        cout << "Y::~Y() Objekt-Nr. = " << mXObjNr << "\n";
    }

private:

};

class Z : Y {
public:

    Z() {
        cout << "Z::Z() Objekt-Nr. = " << mXObjNr << "\n";
    }

    ~Z() {
        cout << "Z::~Z() Objekt-Nr. = " << mXObjNr << "\n";
    }
private:

};

class A {
public:

    A() {
        cout << "A::A()\n";
    }

    ~A() {
        cout << "A::~A()\n";
    }

private:

};

class B : A {
public:

    B() {
        cout << "B::B()\n";
    }

    ~B() {
        cout << "B::~B()\n";
    }

private:
    Y mY;

};

class C : public B {
public:

    C() {
        cout << "C::C()\n";
    }

    ~C() {
        cout << "C::~C()\n";
    }
private:
    Z mZ;


};


int X::mXObjCounter = 0;

int main() {

    {
        C c;
    } // Destruktoren müssen hier automatisch aufgerufen werden ;-)

    return 0;
}


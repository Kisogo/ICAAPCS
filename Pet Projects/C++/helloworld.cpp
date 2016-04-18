#include <string>
#include <sstream>
#include <iostream>
using namespace std;

// declaring functions

int power(int a, int b)
{
    int tmp = a;
    
    for(int i = 1; i <= b; i++)
    {
        a *= tmp;
    }
    
    return a;
}
// declaring inline functions
// the inline keyword suggests that the body of the function\
   be placed in the space where the function is called\
   rather than calling the function itself.

inline void square(int& a)
{
    a = a*a;
}

// passing arguments by reference using &
/* passing a reference as an argument allows the function to
   modify the value of the argument outside of the function's scope.  */ 
inline void inverse(int& a)
{
    a = -a;
}

// optional parameters
inline float lerp(float v0, float v1, float t = 1.0) // curve fitting using linear interpolation
{
    return (1-t)*v0 + t*v1;
}

// function templates
template <class T>
T sum(T a, T b)
{
    T result;
    result = a + b;
    return result;
}

template <class T, class U>
bool are_equal(T a, U b)
{
    return (a==b);
}

// template arguments
template<class T, int U>
T fixed_multiply(T val)
{
    return val * U;
}

int main()
{
    // Declaring variables
    string mystring, hello, world;
    mystring = "Hello World!";
    hello = "Hello";
    world = "World!";
    
    // Line continuation using '\'
    string mstring;
    mstring = "This string is declared\
 on two lines";
    
    // Printing string and newline using cout
    cout << mystring << endl;               // Hello World!\n
    cout << hello << endl << world << endl; // Hello\nWorld!
    cout << mstring << endl;
    
    /*
    // Getting strings from cin
    string instring;
    cout << "What's your name?\n";
    getline (cin, instring);
    cout << "Hello " << instring << ".\n";
    cout << "What? ";
    getline (cin, instring);
    cout << "I wanna " << instring << " that window.\n";
    */
    
    /*
    // Using stringstream to extract int from string
    float price = 128.64;
    string strquan;
    int quantity;
    
    cout << "The price is: " << price << "\n How many would you like to buy?: ";
    getline (cin, strquan);
    stringstream(strquan) >> quantity;
    cout << "The total cost is $" << price*quantity << ".";
    */
    
    // While loops
    int a, b, c;
    a = 0;
    b = 1;
    c = a+b;
    
    while(b < 100)
    {
        cout << c << endl;
        a = b;
        b = c;
        c = a+b;
    }
    
    /*
    // do-while loops
    string line;
    do {
        cout << "Enter text: ";
        getline (cin, line);
        cout << "You entered: " << line << endl;
    } while (line != "goodbye"); 
    */
    
    // for-each loops (requires -std=c++11 compiler flag)
    string fastring {"Hello!"};
    for(char c: fastring)
    {
        cout << "[" << c << "]";
    } 
    cout << endl;
    
    // for-each automatic type deduction
    for(auto c: fastring)
    {
        cout << "[" << c << "]";
    }
    cout << endl;
    
    // calling functions
    cout << "power (2,8): " << power (2,8) << endl;
    
    int sq = 4;
    square (sq);
    cout << "square (sq): " << sq << endl;
    
    inverse (sq);
    cout << "inverse (sq): " << sq << endl;
    
    cout << "lerp (0, 25): " << lerp (0, 25) << endl;
    cout << "lerp (0, 25, 0.5): " << lerp (0, 25, 0.5) << endl;
    
    cout << "sum<int>(10, 100): " << sum<int>(10, 100) << endl;
    
    cout << "are_equal(10, 10.0): " << are_equal(10, 10.0) << endl; // is equivalent to are_equal<int, double>(10, 10.0), uses automatic template parameter deduction.

    cout << "fixed_multiply<int,2>(10): " << fixed_multiply<int,2>(10) << endl; // creates a version of fixed_multiply at compile-time where the template argument is always 2.

    // main method returns int
    return 0;
}

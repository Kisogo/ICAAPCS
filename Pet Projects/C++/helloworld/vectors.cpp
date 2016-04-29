#include <iostream>
#include <vector>
using namespace std;

int main()
{
    /* Functions provided by the vector class:
    
        unsigned int size();        Returns the number of elements in a vector.
        push_back(type element);    Adds an element to the end of a vector.
        bool empty();               Returns true of the vector is empty.
        void clear();               Erases all elements of the vector.
        type at(int n);             Returns the element at index n, with bounds checking.
        
        Requires compiler flag -std=c++11 or -std=gnu11.
    */
    
    vector <int> vec;   // New empty integer vector.
    
    vec.push_back(3);   // Add element 3 to end of vec.
    vec.push_back(10);  // Add element 10 to end of vec.
    
    // Getting elements from a vector works just like an array.
    for(int x=0; x < vec.size(); x++)
    {
        cout << vec[x] << " "; // Should output: 3 10
    }
    
    cout << endl;
    
    // If the vector isn't empty, clear it.
    if(!vec.empty())
        vec.clear();
        
    vector <int> vec2;  // Another empty integer vector.
    
    vec2.push_back(10);
    vec.push_back(10);
    
    // Test equality.
    if(vec == vec2)
    {
        cout << "vec is equal to vec2." << endl;
        vec.push_back(20);
    }
    
    for(int y=0; y < vec.size(); y++)
    {
        cout << vec[y] << " "; // Should output: 10 20
    }
    
    // Clear vec.
    vec.clear();
    
    /* Create 1024 new elements using push_back.
       New elements will be dynamically allocated and managed.
    */
    for(int i=0; i <= 1024; i++)
    {
        vec.push_back(i);
    }
    
    for(int j=0; j < vec.size(); j++)
    {
        cout << vec[j] << ", ";
    }
    
    return 0;
}

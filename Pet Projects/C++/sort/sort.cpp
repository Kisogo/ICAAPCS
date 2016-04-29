#include <iostream>
#include <vector>
using namespace std;

class Data {
    /* !! All members of a class declared before any other access
          specifier has private access automatically. */
       
    /* When declared outside of any function, arrays are
       universally initialized, removing the need for an equal
       sign between the declaration and the initializer.
       Requires compiler flag -std=c++11 or -std=gnu++11. */
       
    // int arr [1024] { };   
       
    /* Buuuut, we're going to use a vector, which grows
       dynamically to however many elements encountered at
       runtime. */
          
    vector<int> vec;
    
    // Private function. Returns true if i is within bounds of vec.
    bool in_bounds(int i) {
        if(i < vec.size() && i >= 0) {
            return true;
        } else {
            return false;
        }
    }
   
   
    public:
        // Print vector to stdout.
        void print_vector() {
            for(auto i: vec) {
                cout << i << ' ';
            }   
        }
        
        // Dump copy of vec.
        vector<int> inline dump_vector() {
            return vec;
        }

        // Inserts int x at index i, with bounds checking.
        void set_value(int i, int x) {
            if(in_bounds(i) == true) {
                vec[i] = x;
            }
        }

        // Inserts int i at the end of the vector.
        void inline push_value(int i) {
            vec.push_back(i);
        }
        
        // Returns int from index i from private vector, with bounds checking. at implements bounds checking on it's own.
        int inline get_value(int i) {
            vec.at(i);
        }
        
        // Removes all elements contained in vector.
        void clear_vector() {
            vec.clear();
        }
        
        // Sort private vector.
        void sort() {
            // TODO: Implement sorting algorithm.
            
            
        }
};


int main()
{
    Data d;
    
    int j = 0;
    
    // Push 1024 elements to vector.
    for(int j=0; j <= 1024; j++) {
        d.push_value(j);
    }
    
    // Dump vector and print elements to stdout.
    for(int i: d.dump_vector()){
        cout << i << ' ';
    }
    
    // Print elements to stdout automatically.
    d.print_vector();
    
	return 0;
}

#include <stdio.h>

int main()
{
    // int n = 10
    int i;
    long x = 1;
    long y = 0;
    long z = 0;
    
    for( i = 0; i <= 25; i++ ) {
        z = x + y;
        x = y;
        
        printf("%d\n", z);
        
        y = z;
    }
    return 0;
}
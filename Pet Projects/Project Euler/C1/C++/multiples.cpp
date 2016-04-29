#include <iostream>

int mults(int a, int l)
{
    int i = 1;
    int b = a;
    while(a * i < 1000)
    {
        b = b + (a * i);
        i = i + 1;
    }
    
    return b;
}

int main()
{
    std::cout << mults(3, 1000) + mults(5, 1000);

	return 0;
}

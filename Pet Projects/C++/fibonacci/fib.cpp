#include <iostream>
using namespace std;

void fibonacci (long a, long b, int i)
{
	long c = a + b;

	for(int j = 1; j != i; j++)
	{
		c = a + b;
		cout << c << " ";

		a = b;
		b = c;
	}
}

int main()
{
	fibonacci(1, 0, 100);
    return 0;
}

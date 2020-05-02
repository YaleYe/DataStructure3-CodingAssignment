#include <iostream>
using namespace std;
/*swapByValue swaps two values
swapByReference swaps two values references*/


int swapByValue(int a, int b) {
	int t = a;
	a = b;
	b = t;
	return 0;
}

int swapByReference(int& a, int& b) {
	int t = a;
	a = b;
	b = t;
	return 0;
}

int main()
{
	int a = 3;
	int b = 4;
	swapByValue(a, b);
	printf("Swap by values results:  ");
	printf("a:%d, b:%d", a, b);
	swapByReference(a, b);
	printf("\n");
	printf("Swap by value references:  ");
	printf("a:%d, b:%d", a, b);
	cin >> a;
	return 0;
}



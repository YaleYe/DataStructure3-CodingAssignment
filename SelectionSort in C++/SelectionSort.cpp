#include <iostream>
using namespace std;
/*This Program is about using pointers for selection sort and binary search
Name:Yihong Ye, class: Data Stucture III*/
void swap(int *a, int *b) {
	int temp = *a;
	*a = *b;
	*b = temp;
}
void selectionSort(int* low, int* high) {
	for (int *index = low;index <= high;index++) {
		int min = *index;  //assign min as first item
		for (int *index2 = low ;index2 <= high;index2++) {
			if (min < *index2) { //if min is larger, then swap two 
				//cout << *index2 << " index2: "; //swap first 
				swap(*index2, *index);
				min = *index;
			}
		}
	}
}

void printList(int* low, int* high) {
	for (int *p = low; p <= high; p++)
		cout << *p << " ";
}

int* binSearch(int* low, int* high, int key) {
	int addr = (high - low)/2 ;
	if (addr >= 1) {
		if (*(low + addr) == key) {
			printf("\nKey Found\n ");
			return (low + addr);
		}
		if (*(low + addr) >= key) {
			return binSearch(low, (low + addr), key);
		}
		if (*(low + addr) <= key) {
			return binSearch((low + addr), high, key);
		}
	}
	else
		printf("\nKey is not found\n");
		return high + 1;
	}

int main() {
	int numList[] = {123,12,32,54,42,39,534};
	int *low = numList, *high = numList + sizeof(numList) / sizeof(numList[0])-1;
	printf("Your initial array is:\n");
	printList(low, high);
	selectionSort(low, high);
	printf("\nYour current array is:\n");
	printList(low, high);
	int* addr = binSearch(low, high, 123);
	cout << *(addr) <<"<---- key\n ";
	cout << addr <<"<--- pointer address";
	cout << endl;
	getchar();
	getchar();
	return 0;
}

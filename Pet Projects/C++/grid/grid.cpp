#include <iostream>
using namespace std;

class Buffer {

	// Requires compiler flag -std=c++11 or gnu++11
	const static int XMAX = 32;
	const static int YMAX = XMAX;

	const char TCHAR = '#';
	const char FCHAR = ' ';

	bool buf [XMAX][YMAX]; // a 'buffer' is just a 2D array.

	//resetBuffer();

	bool isInBounds (int i) {
		if(i <= XMAX) {
			return true;
		} else {
			return false;
		}
	}
/*
	bool isInBounds (int [] i) {
		for(int j : i) {
			if(j <= XMAX) {

			} else {
				return false;
			}
		return true;
	}
*/

	char asChar(bool b) {
		if(b == true) {
			return TCHAR;
		} else {
			return FCHAR;
		}
	}

	public:

/*	 Compares two elements
	bool cmpValue(int x1, int y1, int x2, int y2) {
		int [] arr = {x1, y1, x2, y2};

		if(isInBounds(arr)) {
			if(buf [x1][y1] >
*/

	// Gets one element
	bool getValue(int x, int y) {
		return buf [x][y];
	}

	// Sets one element
	void setValue(int x, int y, bool value) {
		if(isInBounds(x) && isInBounds(y)) {
			buf [x][y] = value;
		} else {

		}
	}

	// Sets all buffer elements to false
	void resetBuffer() {
		for(int i = 0; i < XMAX; i++) {
			for(int j = 0; j < YMAX; j++) {
				buf [i][j] = false;
			}
		}
	}

	// Draws buffer contents using stdout
	void drawBuffer() {
		for(int i = 0; i < XMAX; i++) {
			for(int j = 0; j < YMAX; j++) {
				cout << asChar(buf [i][j]) << ' ';
			}
			cout << endl;
		}
	}
/* buf is an automatically allocated array. This function is not needed unless
   we declare the array using keyword new.

	void closeBuffer() {
		delete buf;
	}
*/
};

int main()
{
	Buffer buff;
	buff.resetBuffer();

	buff.setValue(16, 33, true);

	buff.drawBuffer();



}



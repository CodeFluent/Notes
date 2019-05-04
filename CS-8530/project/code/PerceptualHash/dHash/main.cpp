#include<iostream>
#include <fstream>
#include <string>


using namespace std;

int main()
{

	string fileName;

	// GPU calculations

	greyscale();
	resize(); // always run after greyscale
	hash();

	


	return 0;
}
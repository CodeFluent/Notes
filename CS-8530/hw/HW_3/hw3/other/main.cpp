#include<opencv2/opencv.hpp>
#include<iostream>
#include <fstream>
#include <string>



using namespace std;
using namespace cv;
int main()
{
	// input operation
	string fileName;

	cout << "Enter image file name, ex) img.jpg: " << endl;	// asks user to input filename
	cin >> fileName;				// inputs user input into fileName
	
	Mat img = imread(fileName);		// uses opencv to parse in image
		
	int rows = img.rows;
	int cols = img.cols;

	cv::Size s = img.size();		// gets image size
	rows = s.height;				// gets image height
	cols = s.width;					// gets image width

	printf("%d \n", rows);
	printf("%d \n", cols);






	   
	return 0;
}

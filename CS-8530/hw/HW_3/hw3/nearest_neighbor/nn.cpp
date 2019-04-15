//#include <iostream>
//using namespace std;
//int main()
//{
//	cout << "Hello World";
//	return 0;
//}


#include<opencv2/opencv.hpp>
#include<iostream>
#include <fstream>
#include <string>



using namespace std;
using namespace cv;
int main(int argc, char **argv)
{
	// get the path of the image via the args.
	// note that the image must be in the same directory.
	char* fileName =  argv[1];	


	Mat img = imread(fileName, 1);		// uses opencv to parse in image

	int rows = img.rows;
	int cols = img.cols;

	cv::Size s = img.size();		// gets image size
	rows = s.height;				// gets image height
	cols = s.width;					// gets image width

	printf("%d \n", rows);
	printf("%d \n", cols);







	return 0;
}

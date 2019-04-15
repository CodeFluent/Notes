//#include <iostream>
//using namespace std;
//int main()
//{
//	cout << "Hello World";
//	return 0;
//}


#include <opencv2/core/mat.hpp>
#include <opencv2/highgui.hpp>
#include <iostream>
#include <fstream>
#include <string>




using namespace std;
using namespace cv;
int main()
{

	char* fileName = "kodim02.jpg";

	Mat img = imread(fileName, 1);		// uses opencv to parse in image. note the 1 flag means 3-channel BGR data. (actually BGR not RGB)

	if (!img.data) // check for null image data
	{
		printf("No image data \n");
		return -1; // exit with error
	}

	int rows = img.rows;
	int cols = img.cols;

	cv::Size s = img.size();		// gets image size
	rows = s.height;				// gets image height
	cols = s.width;					// gets image width

	printf("%d \n", rows);
	printf("%d \n", cols);

	// write out the image to the current directory
	imwrite("output.jpg", img);
	
	// GUI stuff
	namedWindow(fileName);
	namedWindow("processed image");

	imshow(fileName, img); // original 
	imshow("processed image", img);  // processed

	waitKey(0);






	return 0;
}

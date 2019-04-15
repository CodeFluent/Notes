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


const int SCALE_FACTOR = 2;

/* 
	Do a nearest neighbor interpolation. 

	

	- Get the size of the new image with the scaling factor.
	- calculate the scaling ratio for all pixels
	- loop over all pixels, round pixel postion/scaling factor to get new position

*/
void interpolate(int row, int col)
{
	Mat output_img;
	output_img = Mat::zeros(row * SCALE_FACTOR, col * SCALE_FACTOR, CV_16F); 

	//output_img = Mat::zeros()

}

int main()
{

	const char* fileName = "kodim02.jpg";

	Mat img = imread(fileName, 1);		// uses opencv to parse in image. note the 1 flag means 3-channel BGR data. (actually BGR not RGB)

	if (!img.data) // check for null image data
	{
		printf("No image data \n");
		return -1; // exit with error
	}

	int rows = img.rows;
	int cols = img.cols;

	int type = img.type;


	printf("%d \n", rows);
	printf("%d \n", cols);
	printf("%d \n", type);


	interpolate(rows, cols);

	// write out the image to the current directory
	imwrite("output.jpg", img);
	
	// GUI stuff
	namedWindow(fileName);
	namedWindow("processed image (Press any key to exit)");

	imshow(fileName, img); // original 
	imshow("processed image (Press any key to exit)", img);  // processed


	waitKey(0);






	return 0;
}

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

// User defined variables. 
const int SCALE_FACTOR = 2;
const char* FILENAME = "kodim02.jpg";

/* 
	Do a nearest neighbor interpolation. 
	
	- Get the size of the new image with the scaling factor.
	- calculate the scaling ratio for all pixels
	- loop over all pixels, round pixel postion/scaling factor to get new position

*/
void interpolate(int row, int col, string type)
{	

	// Get the size of the new image
	int nrows = row * SCALE_FACTOR; 
	int ncol = col * SCALE_FACTOR;

	// Allocate new image of kn x km size.
	Mat output_img;
	int image_type = atoi(type.c_str());
	output_img = Mat::zeros(nrows, ncol, image_type); 

	// Get the scaling factors for each pixel. 
	// It will be the new image width/height divided by the old one.
	float c_X = nrows / row;
	float c_Y = ncol / col;

	// Get the nearest neighboring pixel to assign to the new image.
	int i, j; 
	for (i = 0; i < nrows; ++i)
	{
		for (j = 0; j < ncol; ++j)
		{
			x = c_X *  
		}
	}
	
	


}
// From StackOverflow, getting image type to make sure correct data type
// TODO: based on data type, return an array or struct with all required flags.
string type2str(int type) {
	string r;

	uchar depth = type & CV_MAT_DEPTH_MASK;
	uchar chans = 1 + (type >> CV_CN_SHIFT);

	switch (depth) {
	case CV_8U:  r = "8U"; break;
	case CV_8S:  r = "8S"; break;
	case CV_16U: r = "16U"; break;
	case CV_16S: r = "16S"; break;
	case CV_32S: r = "32S"; break;
	case CV_32F: r = "32F"; break;
	case CV_64F: r = "64F"; break;
	default:     r = "User"; break;
	}

	r += "C";
	r += (chans + '0');

	return r;
}

int main()
{
	Mat img = imread(FILENAME, 1);		// uses opencv to parse in image. note the 1 flag means 3-channel BGR data. (actually BGR not RGB)

	if (!img.data) // check for null image data
	{
		printf("No image data \n");
		return -1; // exit with error
	}

	int rows = img.rows; // get the width of the image
	int cols = img.cols; // get the height of the image

	int type = img.type(); // get the type of image.
	string image_type = type2str(type);

	printf("\nWidth %d ", rows);
	printf("\nHeight %d ", cols);
	printf("\nMatrix Type: %s ", image_type);



	interpolate(rows, cols, image_type);

	// write out the image to the current directory
	imwrite("output.jpg", img);
	
	// GUI stuff
	namedWindow(FILENAME);
	namedWindow("processed image (Press any key to exit)");

	imshow(FILENAME, img); // original 
	imshow("processed image (Press any key to exit)", img);  // processed


	waitKey(0);






	return 0;
}

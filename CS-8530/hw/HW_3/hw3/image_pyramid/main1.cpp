#include<opencv2/opencv.hpp>
#include<iostream>
#include <fstream>
#include <string>


using namespace std;
using namespace cv;
int main()
{
    // run on CPU
    // input operation
    string fileName;

    cout << "Enter image file name, ex) img.jpg: " << endl;    // asks user to input filename
    cin >> fileName;                // inputs user input into fileName
    
    Mat img = imread(fileName);     // uses opencv to parse in image
    
    unsigned char *fpt = &img;      // pointer to image
    int rows = img.rows;
    int cols = img.cols;

    Size s = img.size();            // gets image size
    rows = s.height;                // gets image height
    cols = s.width;                 // gets image width

    printf("%d \n", rows);
    printf("%d \n", cols);
    
    int len = rows*cols;
        
    int levels;
    cout << "Enter number of levels: " << endl;    // asks user to input number of levels
    cin >> levels;                // input levels
    
    
    // GPU calculations
    cuda1(len, rows, cols, *fpt, levels);
    
    // print pointer to resulting pyramid images
    unsigned char *result;
    int i = 0;
    for (i=0, i<levels, i++){
        cout << *result << endl;
    }
    
    
    
    return 0;
}
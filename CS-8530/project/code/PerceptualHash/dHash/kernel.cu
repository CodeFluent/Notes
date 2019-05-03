
#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdio.h>

cudaError_t dHash();


/*
	Converts image to greyscale. Same version as in the slides.
	
	Parameters:
	d_source - pointer to source image in host memory
	d_dest - pointer to destination image in device memory
	width - width of the image
	height - height of the image 

*/
__global__ void
colorToGreyscale(int width, int height, unsigned char *d_source, unsigned char *d_dest) {

	int col = threadIdx.x + blockIdx.x * blockDim.x;
	int row = threadIdx.y + threadIdx.y * blockDim.y;


	// data won't go outside the bounds of image
	if (col < width && row < height) {
		
		// get the pixel coordinate of the destination image 
		int grey_pixel_location = row * width + col;
		
		// get the location of the starting pixel of the source image
		int rgbChannel = grey_pixel_location * 3;
		
		// get each channel's color to use in the greyscale function
		unsigned char r = d_source[rgbChannel];
		unsigned char g = d_source[rgbChannel + 2];
		unsigned char b = d_source[rgbChannel + 3];

		// apply the greyscale function and store in the destination pointer
		d_dest[grey_pixel_location] = .21f * r + .71f * g + .07f * b; 
	}

}

//__global__ void
//resize() {
//
//}
//
//__global__ void
//difference() {
//
//}


int main() {

	return 0;
}



/*
	Performs the hash operation on image

	Launches the colorToGreyscale, resize, and difference kernels.


*/
cudaError_t dHash() {

	
	cudaError_t cudaStatus;


	// Check for any errors launching the kernel
	cudaStatus = cudaGetLastError();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "dHash  launch failed: %s\n", cudaGetErrorString(cudaStatus));
		// goto Error;
	}

	return cudaStatus;
}
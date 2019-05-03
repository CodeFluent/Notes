
#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdint.h>
#include <stdio.h>

#define STB_IMAGE_IMPLEMENTATION
#include <stb_image.h>
#define STB_IMAGE_WRITE_IMPLEMENTATION
#include <stb_image_write.h>

#define CHANNELS 3 



cudaError_t dHash(int height, int width, uint8_t *d_source, unsigned int *d_dest);

unsigned int *dImage = NULL;   //storing final result


/*
	Converts image to greyscale. Same version as in the slides.
	
	Parameters:
	d_source - pointer to source image in host memory
	d_dest - pointer to destination image in device memory
	width - width of the image
	height - height of the image 

*/
__global__ void
colorToGreyscale(int height, int width, uint8_t *d_source, unsigned int *d_dest) {

	int col = threadIdx.x + blockIdx.x * blockDim.x;
	int row = threadIdx.y + threadIdx.y * blockDim.y;


	// data won't go outside the bounds of image
	if (col < width && row < height) {
		
		// get the pixel coordinate of the destination image 
		int grey_pixel_location = row * width + col;
		
		// get the location of the starting pixel of the source image
		int rgbChannel = grey_pixel_location * CHANNELS;
		
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



/*
	Performs the hash operation on image

	Launches the colorToGreyscale, resize, and difference kernels.
	Also manages mallocs and error handling for each step.


*/
cudaError_t dHash(int height, int width, int bpp, uint8_t *d_source, unsigned int *d_dest) {



	cudaError_t cudaStatus;


	// intial 16x16 block size for the first two kernels.
	dim3 gridSize(ceil(height / 16.0), ceil(width / 16.0), 1);
	dim3 blockSize(16, 16, 1);



	colorToGreyscale<<<gridSize, blockSize>>> (width, height, d_source, d_dest);


	// Check for any errors launching the kernel
	cudaStatus = cudaGetLastError();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "dHash launch failed: %s\n", cudaGetErrorString(cudaStatus));
		// goto Error;
	}

	return cudaStatus;
}

void freeImages(uint8_t *image) {
	stbi_image_free(image);
}

/*
	Runs the entire file. Both intializes and frees resources.
*/
int main() {

	//intialize rgb image
	int width, height, bpp = 0; // last one is bits per pixel
	uint8_t* rgb_image = stbi_load("kodim02.png", &width, &height, &bpp, CHANNELS);

	//intialize 
	uint8_t* grey_image;
	grey_image = (uint8_t *) malloc(width * height * 1);


	cudaError_t cudaStatus = dHash(height, width, bpp, rgb_image, dImage);
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "dHash failed!");
		return 1;
	}

	stbi_write_png("image.png", width, height, 1, grey_image, width*1);

	// According to template, Visual Profiler needs this to help profile.
	cudaStatus = cudaDeviceReset();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "cudaDeviceReset failed!");
		return 1;
	}

	//free images
	freeImages(rgb_image);
	
	return 0;
}



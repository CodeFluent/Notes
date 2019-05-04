
#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdint.h>
#include <stdio.h>

#define STB_IMAGE_IMPLEMENTATION
#include <stb_image.h>
#define STB_IMAGE_WRITE_IMPLEMENTATION
#include <stb_image_write.h>

#define CHANNELS 3


/*
	Converts image to greyscale. Same version as in the slides.
	
	Parameters:
	rgb_image - pointer to source image in host memory
	grey_image - pointer to destination image in device memory
	height - height of the image 
	width - width of the image

*/
__global__ void
colorToGreyscale(unsigned char* rgb_image, unsigned char* grey_image, int height, int width ) {

	int col = threadIdx.x + blockIdx.x * blockDim.x;
	int row = threadIdx.y + threadIdx.y * blockDim.y;

	// data won't go outside the bounds of image
	if (col < width && row < height) {

		// get the pixel coordinate of the destination image 
		int pixel_location = row * width + col;

		// get the location of the starting pixel of the source image
		int rgbChannel = pixel_location * CHANNELS;

		// get each channel's color to use in the greyscale function
		unsigned char r = rgb_image[rgbChannel];
		unsigned char g = rgb_image[rgbChannel + 2];
		unsigned char b = rgb_image[rgbChannel + 3];

		// apply the greyscale function and store in the destination pointer
		grey_image[pixel_location] = .21f * r + .71f * g + .07f * b;
	}
}


void freeImages(uint8_t *image) {
	stbi_image_free(image);
}


/*
	Runs the entire file. Both intializes and frees resources.
*/
int main() {

	int width, height, bpp = 0; // last one is bits per pixel
	cudaError_t cudaStatus;

	// Allocate host images
	unsigned char* h_rgb_image = stbi_load("kodim02.png", &width, &height, &bpp, CHANNELS);

	unsigned char* h_grey_image = (unsigned char *)malloc(width * height * 1);
	
	// Allocate device images
	unsigned char* d_rgb_image;
	unsigned char* d_grey_image;
	int rgb_size = sizeof(h_rgb_image);
	int grey_size = sizeof(h_grey_image);
	cudaMalloc((void**)&d_rgb_image, rgb_size);
	cudaMalloc((void**)&d_grey_image, grey_size);


	// Copy values from host to device
	cudaMemcpy(d_rgb_image, &h_rgb_image, rgb_size, cudaMemcpyHostToDevice);
	cudaMemcpy(d_grey_image, &d_grey_image, grey_size, cudaMemcpyHostToDevice);

	// Check to make sure everything went fine
	cudaStatus = cudaGetLastError();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "malloc failed!");
		return 1;
	}

	// intial 16x16 block size for the first two kernels.
	dim3 gridSize((width + 16 - 1) / 16, (height + 16 - 1) / 16);
	dim3 blockSize(16, 16, 1);

	// launch kernel
	colorToGreyscale << <gridSize, blockSize >> > (d_rgb_image, d_grey_image, height, width);

	// copy device grey image back to host
	cudaMemcpy(&d_grey_image, h_grey_image, grey_size, cudaMemcpyDeviceToHost);

	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "dHash failed!");
		return 1;
	}

	stbi_write_png("image.png", width, height, 1, h_grey_image, width*1);

	// According to template, Visual Profiler needs this to help profile.
	cudaStatus = cudaDeviceReset();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "cudaDeviceReset failed!");
		return 1;
	}

	//free images and arrays
	freeImages(h_rgb_image);
	freeImages(h_grey_image);


	
	return 0;
}



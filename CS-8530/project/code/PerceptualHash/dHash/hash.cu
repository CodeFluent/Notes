
#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdint.h>
#include <stdio.h>


#include <stb_image.h>

#include <stb_image_write.h>

#define CHANNELS 1 



/*
	Creates hash of processed image.

	Parameters:
	image - pointer to source image in device memory
	height - height of the image
	width - width of the image


*/
__global__ void
hash(unsigned char* image, int height, int width, int64_t* hash ) {

	// calculate the difference between each column
	int col = threadIdx.x + blockIdx.x * blockDim.x;
	int row = threadIdx.y + threadIdx.y * blockDim.y;

	// data won't go outside the bounds of image
	if (col < width && row < height) {

		// get the pixel coordinate of the col
		int pixel_location = row * width + col;

		// get the pixel coordinate of the next col
		int next_col = pixel_location + 1;

		// compare the difference of the pixels in these two cols.
		if (image[pixel_location] < image[next_col]) {
			hash += image[next_col] - image[pixel_location];
		} 
		if (image[pixel_location] > image[next_col]) {
			hash += image[pixel_location] - image[next_col];
		}
		else {
			hash += image[pixel_location];
		}
		

	}
}


/*
	Runs the entire file. Both intializes and frees resources.
*/
void hash() {

	int width, height, bpp = 0; // last one is bits per pixel

	// calculate dimensions of new image. Either height or width must be larger than the other by 1 row or col. 
	// This is to promote the difference hash in the next kernel to prevent against scaling attacks.
	int new_height = height / 4;
	int new_width = new_height + 1;

	cudaError_t cudaStatus;

	// Allocate host image
	unsigned char* h_image = stbi_load("kodim02.png", &width, &height, &bpp, CHANNELS);
	unsigned char* h_image_result = (unsigned char *)malloc(new_height * new_width * 1);

	// Allocate device images
	unsigned char* d_image;
	int size = sizeof(h_image);
	cudaMalloc((void**)&d_image, size);


	// Copy values from host to device
	cudaMemcpy(d_image, &h_image, size, cudaMemcpyHostToDevice);

	// Check to make sure everything went fine
	cudaStatus = cudaGetLastError();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "malloc failed!");
	}

	// intial 16x16 block size for the first two kernels.
	dim3 gridSize((width + 16 - 1) / 16, (height + 16 - 1) / 16);
	dim3 blockSize(16, 16, 1);

	// launch kernel
	hash << <gridSize, blockSize >> > (d_image, height, width, new_height, new_width);

	cudaDeviceSynchronize();

	// copy device grey image back to host
	cudaMemcpy(h_image_result, d_image, sizeof(h_image_result), cudaMemcpyDeviceToHost);

	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "hash failed!");

	}

	stbi_write_png("image.png", width, height, CHANNELS, h_image_result, width*CHANNELS);

	// According to template, Visual Profiler needs this to help profile.
	cudaStatus = cudaDeviceReset();
	if (cudaStatus != cudaSuccess) {
		fprintf(stderr, "cudaDeviceReset failed!");
	}


}



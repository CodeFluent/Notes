
#include "cuda_runtime.h"
#include "device_launch_parameters.h"

#include <stdio.h>

cudaError_t dHash();

__global__ void
colorToGreyscale() {

	int col = threadIdx.x + blockIdx.x * blockDim.x;
	int row = threadIdx.y + threadIdx.y * blockDim.y;

}

__global__ void
resize() {

}

__global__ void
difference() {

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
		goto Error;
	}

}
#include "cuda1.h"
#include "cuda_runtime.h"
#include "device_launch_parameters.h"

// Cuda function 
// Runs on GPU
__global__
void cuda1(int length, int height, int width, unsigned char *img, int num) {
    
    // Allocate space for device
    int *d_length;
    int size = sizeof(int);
    cudaMalloc((void **)&d_length, size);
        
    // Copy array size from the host to the device
    cudaMemcpy(&d_length, d_length, size, cudaMemcpyHostToDevice);
    
    int Col = bloxkIdx.x * blockDim.x + threadIdx.x;
    int Row = bloxkIdx.y * blockDim.y + threadIdx.y;
    
    // set to 0 if boundary conditions are not met
    if (Col < width && Row < h) {
        int pixVal = 0;
        int pixels = 0;
    
    
        // Get average of surrounding blur box
        for (int blurRow = -BLUR_SIZe; blurRow < BLUR_SIZE+1; ++blurRow) {
            for (int blurCol = -BLUR_SIZe; blurCol < BLUR_SIZE+1; ++blurCol) {
                int curRow = Row + blurRow;
                int curCol = Col + blurCol;
                
                // verifies if pixel is valid
                if (curRow > -1 && curRow < height && curCol >-1 && curCol < width)
                {
                    pixels++; // keep track of pixels in average
                }
            }
        }
        
        // Write new pixel value
        out[Row * width + Col] = (unsigned char)(pixVal / pixels);
    
    }


    // Copy result back to the host
    cudaMemcpy(&d_length, d_length/4, size/4, cudaMemcpyDeviceToHost);

    // Free cuda memory
    cudaFree(d_length); 

}
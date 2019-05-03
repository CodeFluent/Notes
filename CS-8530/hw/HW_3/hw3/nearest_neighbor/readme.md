Ha Hwang and Wasfi Momen


Nearest Neighbor
================


Solution to Homework 3 Question 2. Main file with algorithm is "nn_kernel.cu".


To run using Visual Studio,

	- Be sure to use Visual Studio 2017. Newer versions might be fine.
	- Install Windows SDK 10.0.15063.0
		- (You can do this from the "Visual Studio Installer and check 
		for it under "Individual Components Tab". Might have to click 
		"Modify" on the launch screen)
	- Install CUDA toolkit 10.1
	- Install OpenCV 4.1.0
		- Use this link for adding to path: [opencv setup for windows](https://www.deciphertechnic.com/install-opencv-with-visual-studio/) 
		- This vcxproj file uses system variables ([macros](https://docs.microsoft.com/en-us/cpp/build/reference/common-macros-for-build-commands-and-properties?view=vs-2017)) instead:
			- $(OPENCV_EXEC_PATH) -> opencv\build\x64\vc14\bin
			- $(OPENCV_INCLUDE_DIR) -> opencv\build\include
			- $(OPENCV_LIB_DIR) -> opencv\build\x64\vc14\lib
	- Open the solution file
	- Build and run the solution
	- Regret everything and switch back to Linux because its simpler. 


Congrats! ~~If you did everything right you should see the result in the "output" folder.~~ 
You will have also wasted 10 allotted hours trying to deal with Visual Studio. (+4 knowledge +10 hatred for Windows -8 hours of sleep)
Write a program that calls:
- a method minToFront that takes an ArrayList of integers as a parameter. The method moves the minimum value in the list to the front, otherwise preserving the order of the elements.
   - For example, if a variable called list stores the following values: [4,7,9,2,7,7,5,3,5,1,7,8,6,7] and you make this call minToFront(list); it should store the following values after the call: [1,4,7,9,2,7,7,5,3,5,7,8,6,7]. You may assume that the list stores at least one value. After the call print the list.


- another method filterRange that accepts an ArrayList of integers and two integer values min and max as parameters and removes all elements whose values are in the range min through max (inclusive).
   - For example, if a variable called list2 stores the values: [1,4,7,9,2,7,7,5,3,5,7,8,6,7], the call of filterRange(5,7); should remove all values between 5 and 7, therefore it should change the list to store [1,4,9,2,3,8]. If no elements in range min-max are found in the list, the list's contents are unchanged. If an empty list is passed, the list remains empty. You may assume that the list is not mull. After the call print the list.

"""

sequential_algo.py

A naive algorithm that implements matrix multiplication.

"""


"""
multiply() holds main logic to multiply two matricies A and B.

multiply() doesn't check for bounds or even if it's possible to multiply the matricies. 
Assume both matricies are square of 3 x 3 size. 

mutiply() does matrix multiplication in O(n^3) time since:
    - first for loop must go through n times across rows in A
    - second must go through n times across rows in B
    - third for loop computes result of A[i,k] and B[k,j] but does so n times across C.
    O(n + n + n) = O(n^3)
"""
def multiply(matrixA, matrixB):
    
    # initialize C 
    C = [[0, 0, 0],
         [0, 0, 0],
         [0, 0, 0]]

    # for a row in A...
    for i in range(3):
        # ...and the row in B...
        for j in range(3):
            # ...go across the row of C and get the multiplied values of row A and column B to store.
            for k in range(3):
                C[i][j] += A[i][k] * B[k][j]

    # output C 
    for u in C: 
        print(u)
     


# Anything multiplied by its identity matrix is itself, so it's an easy example.
A = [[1, 0, 0],
     [0, 1, 0],
     [0, 0, 1]]

B = [[1, 2, 3],
     [4, 5, 6],
     [7, 8, 9]]

multiply(A, B)
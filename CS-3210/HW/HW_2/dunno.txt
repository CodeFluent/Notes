/* Write an assembly language program to compute:

    y = (x - 4)(x - 14)

for the range of 0 <= x <= 10, by stepping one by one through the range.

During each iteration, print out a message stating the current value of x and
the corresponding value of y. Make sure to define the values of the constants 4
and 14 as constants a1 and a2 (the TA may change these values to further test
your code).

Output format:

For input of  x = 0, output  y = 56
For input of
x = 1, output  y = 39
...
...
For input of  x = 10, output  y = -24

*/


/* Variables and macros */
define(x_r, l1)
define(y_r, l2)

/* change the following to test further */
define(a1, 4)
define(a2, 14)


.section ".data"
outputString: .asciz "For the input of x = %x, \n"


/* Program starts here */
.align 4
.section ".text"
.global main

main:
    save %sp, -96, %sp
    set outputString, %o0
    mov a2, %o1
    call printf
    nop

    ret
    restore

/* Write an assembly language program to compute:

	y = (x - 4)(x - 14)

for the range of 0 <= x <= 10, by stepping one by one through the range.

During each iteration, print out a message stating the current value of x and
the corresponding value of y. Make sure to define the values of the constants
4 and 14 as constants a1 and a2 (the TA may change these values to further test your
code).

Output format:

For input of x = 0, output y = 56
For input of x = 1, output y = 39
...
...
For input of x = 10, output y = -24

*/

!Variables and Macros

define(x_r, l1)
define(y_r, l2)

!Change the following to test further

define(a1, 4)
define(a2, 14)

.section ".data"
outputString: .asciz "For the input of x = %d, y = %d \n"

.align 4
.section ".text"
.global main

main:
	save %sp, -96, %sp

	mov 0, %x_r

loop:
	sub %x_r, a2, %o0  !(x - 4)
	sub %x_r, a1, %o1  !(x - 14)
	call .mul          !Note that negative numbers will always act positive.
	nop
	mov %o0, %y_r

	set outputString, %o0
	mov %x_r, %o1
	inc %x_r
	call printf
	mov %y_r, %o2 	   !get rid of nop here with y_r being printed.

	cmp %x_r, 10
	ble loop
	nop

	ret
	restore

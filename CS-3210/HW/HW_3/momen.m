/*
    DONE:0 Write an assembly language program to find the maximum of y= 3x^4 - 10x^2 - 15x.
    for the range -4 <= x <= 6.

    During each iteration, print out a message stating the current value of x and the corresponding value of y.

    After all iterations, print out a final message stating the max value of y and the corresponding value of x that generated  ymax. If there are multiple values of x that generate ymax, you only need to indicate one of them.

    DONE:10 Also, make sure to define the values of the coefficents 3, 10, and 15 as constants a1, a2, and a3.

    TODO: Check nops

    BACKLOG: Set up SPARC machine and Ubuntu server. [http://www.cis.upenn.edu/~milom/cross-compile.html](http://www.cis.upenn.edu/~milom/cross-compile.html)


    Output Format:
        For input of x = -4, output y = 668
        For input of x = -3, output y = 198
        ...
        ...
        For input of x = 6, output y = 3438
        The maximum output value is y = ***, when input x = ***
*/

!Variables and Macros

define(x_r, l1)
define(y_r, l2)
define(y_max, l3)


!Change the following to test further

define(a1, 3)
define(a2, 10)
define(a3, 15)

.section ".data"
outputString: .asciz "For the input of x = %d, y = %d \n"
ymaxString: .asciz "The maximum output value is y = %d, when input x = %d."

.align 4
.section ".text"
.global main

main:
	save %sp, -96, %sp

    mov -4 , %x_r
    mov 0, %y_max
    ba loop
    nop

!controls the y_max value
compare:
    mov %y_r, %y_max
    ba here
    nop

loop:
    !3x^4-10x^2-15x

    !x^4
    mov %x_r, %o0
    call .mul           !x^2
    mov %x_r, %o1
    call .mul           !x^3
    mov %x_r, %o1
    call .mul           !x^4
    mov %x_r, %o1
    call .mul

    mov a1, %o1         !3x^4
    mov %o0, %y_r

    mov %x_r, %o0
    call .mul           !x^2
    mov %x_r, %o1
    call .mul
    mov a2, %o1         !10x^2

    sub %y_r, %o0, %y_r !3x^4 - 10x^2

    mov %x_r, %o0
    call .mul           !15x
    mov a3, %o1

    sub %y_r, %o0, %y_r !3x^4 - 10x^2 - 15x

    !Printing
    mov %x_r, %o1
    set outputString, %o0
    call printf
    mov %y_r, %o2

    mov %x_r, %o2       !move x_r to o2 for printing later.



    !Save largest value
    cmp %y_r, %y_max
    bg compare
    nop

here:
    inc %x_r        !increment x_r
    cmp %x_r, 6
    ble loop
    nop

    set ymaxString, %o0
    call printf
    mov %y_max, %o1

    ret
    restore

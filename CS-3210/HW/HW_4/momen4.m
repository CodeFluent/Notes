/*
  Write a program to find and print a Fibonacci sequence of numbers. The Fibonacci sequence is defined by:

  Fn = Fn-2 + Fn-1, where Fo = 0 and F1 = 1.
 */

!Variables and Macros


define(max_value, g2)
define(prevVal, g3)
define(prevPrevVal,g4)
define(currVal, g5)


.section ".data"

input: .word 0
nl: .byte 0   !for newline
format: .asciz "%d"

!to print numbers
output: .asciz "%d "




helloMessage: .asciz "This program prints the Fibonacci sequence.\n"
scanMessage: .asciz "Enter the limit on the largest number to be displayed: "



divMessage: .asciz "The last number %d is divisible by %d.\n"

askQuestion: .asciz "Do you want to print a different sequence (Y/N)?: "

goodbye: .asciz "\nGoodbye."

.align 4
.section ".text"
.global main

main:
  save %sp, -96, %sp

  set helloMessage, %o0         !print hello message
  call printf
  nop

heyo:
  set scanMessage, %o0          !print scan message
  call printf
  nop

  set format, %o0
  set input, %o1
  set nl, %o2
  call scanf
  nop


  ld [%o1], %max_value
  ldub [%o2], %l2

/*Uncommment to print out max_value

  set test, %o0
  mov %max_value, %o1
  call printf
  nop
*/


  mov 1, %o1                            !print out the base case 1
  set output, %o0
  call printf
  nop

  mov 1, %prevVal                         !begin first evaluation
  mov 0, %prevPrevVal

loop:
  add %prevVal, %prevPrevVal, %currVal    !get the value to be outputted now
  mov %prevVal, %prevPrevVal              !swap values for next run fib(n-2)
  mov %currVal, %prevVal                  !swap values for next run fib(n-1)

printLoop:

  cmp %currVal, %max_value                !compare to see if we print the current value
  bg div
  nop

  mov %currVal, %o1                       !print currVal
  set output, %o0
  call printf
  nop

  ba loop                                 !branch to loop always
  nop

div:
  set goodbye, %o0
  call printf
  nop

  ret
  restore

/*
  Write a program to find and print a Fibonacci sequence of numbers. The Fibonacci sequence is defined by:

  Fn = Fn-2 + Fn-1, where Fo = 0 and F1 = 1.
 */

!Variables and Macros

define(x_r, g1)


define(max_value, g2)


.section ".data"

input: .word 0
nl: .byte 0   !for newline
format: .asciz "%d"

!to print numbers
output: .asciz "%d"




helloMessage: .asciz "This program prints the Fibonacci sequence.\n"


divMessage: .asciz "The last number %d is divisible by %d.\n"

askQuestion: .asciz "Do you want to print a different sequence (Y/N)?: "

goodbye: .asciz "Goodbye."


!testing printf
test: .asciz "Number is %d"




.align 4
.section ".text"
.global main

main:
  save %sp, -96, %sp

  mov 0, %x_r                    !intialize x_r as 0

  set helloMessage, %o0         !print hello message
  call printf
  nop

  set format, %o0
  set input, %o1
  set nl, %o2
  call scanf
  nop


  ld [%o1], %l0
  ldub [%o2], %l2
  set test, %o0
  mov %l0, %o1
  call printf
  nop



  ret
  restore

/*
  Write a program to find and print a Fibonacci sequence of numbers. The Fibonacci sequence is defined by:

  Fn = Fn-2 + Fn-1, where Fo = 0 and F1 = 1.
 */

!Variables and Macros



.section ".data"

helloMessage: .asciz "This program prints the Fibonacci sequence.\n"
scanMessage: .asciz "Enter a limit on the largest number to be displayed: "

format: .asciz "%d%c"
nl: .byte 0
input: .word 0

divMessage: .asciz "The last number %d is divisible by %d.\n"

askQuestion: .asciz "Do you want to print a different sequence (Y/N)?: "
format2: "%s"

goodbye: .asciz "Goodbye."

test: "Number is %d"


.align 4
.section ".text"
.global main

main:
  save %sp, -96, %sp

  set helloMessage, %o0         !print hello message
  call printf
  nop

  set scanMessage, %o0          !print scan prompt
  call printf
  nop

  set format, %o0               !get input
  set input, %o1
  set nl, %o2
  call scanf
  nop

  set test, %o0
  call printf
  ld [%o1], %o1


  ret
  restore

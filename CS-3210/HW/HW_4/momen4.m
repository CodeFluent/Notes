/*
  Write a program to find and print a Fibonacci sequence of numbers. The Fibonacci sequence is defined by:

  Fn = Fn-2 + Fn-1, where Fo = 0 and F1 = 1.
 */

!Variables and Macros

define(x_r, g1)


.section ".data"

!for scanf for scanMessage
format: .asciz "%d\n"


input: .word 0

!to print numbers
output: .asciz " "

!for scanf for askQuestion
format2: .asciz "%s"



helloMessage: .asciz "This program prints the Fibonacci sequence.\n"
scanMessage: .asciz "Enter a limit on the largest number to be displayed: "

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

  set scanMessage, %o0          !print scan prompt
  call printf
  nop

  set format, %o0              !get input
  set input, %o1
  call scanf
  nop

  !works until here

  /*
  set input, %o1
  set test, %o0
  call printf
  nop

  !assume input is in %l0
loop:
  cmp x_r, %l0
  bg,a end
  nop

  mov %l0, x_r                  !move our max to to x_r

if:
  cmp %x_r, 1                   !compare input to 1 as base case
  bg then                       !branch if greater than 1
  nop

  !print out the base case
  mov %x_r, %o1
  set output, %o0
  call printf
  nop


then:
  sub %x_r, 1, %o0               !fib(n-1)
  call if
  nop

  mov %o0, %l3                   !save for fib(n-1) + fib(n-2)

  sub %x_r, 2, %o0               !fib(n-2)
  call if
  nop

  add %o0, %l3, %x_r             !fib(n-1) + fib(n-2)

  !print result
  set output, %o0
  call printf
  mov %x_r, %o1



end:
  !divisible function
  !next action function
*/
  ret
  restore
